package ru.ecomshop.productservice.model.mapper.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.ecomshop.productservice.model.dto.category.request.CreateCategoryRequest;
import ru.ecomshop.productservice.model.dto.category.request.UpdateCategoryRequest;
import ru.ecomshop.productservice.model.dto.category.response.CategoryResponse;
import ru.ecomshop.productservice.model.entity.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Mapping(source = "parentId", target = "parent.id")
    Category toCategory(CreateCategoryRequest dto);

    @Mapping(source = "parentId", target = "parent.id")
    void updateCategory(UpdateCategoryRequest dto, @MappingTarget Category category);

    @Mapping(source = "parent.id", target = "parentId")
    @Mapping(source = "subcategories", target = "subcategoryIds")
    CategoryResponse toCategoryResponse(Category entity);

    default List<Long> toSubcategoryIds(List<Category> subcategories) {
        return subcategories.stream()
                .map(Category::getId)
                .toList();
    }
}
