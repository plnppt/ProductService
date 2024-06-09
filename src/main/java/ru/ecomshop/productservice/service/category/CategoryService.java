package ru.ecomshop.productservice.service.category;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ecomshop.productservice.model.dto.category.request.CreateCategoryRequest;
import ru.ecomshop.productservice.model.dto.category.request.UpdateCategoryRequest;
import ru.ecomshop.productservice.model.dto.category.response.CategoryResponse;
import ru.ecomshop.productservice.model.entity.Category;
import ru.ecomshop.productservice.model.mapper.category.CategoryMapper;
import ru.ecomshop.productservice.repository.CategoryRepository;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Collection<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
    }

    public CategoryResponse getCategoryById(Long id) {
        var category = processFindCategoryById(id);
        return categoryMapper.toCategoryResponse(category);
    }

    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = categoryMapper.toCategory(createCategoryRequest);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponse updateCategoryById(Long categoryId, UpdateCategoryRequest updateCategoryRequest) {
        var category = processFindCategoryById(categoryId);
        categoryMapper.updateCategory(updateCategoryRequest, category);
        return categoryMapper.toCategoryResponse(category);
    }

    public void deleteCategoryById(Long categoryId) {
        var category = processFindCategoryById(categoryId);
        categoryRepository.delete(category);
    }

    private Category processFindCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Категории по такому идентификатору не существует")
        );
    }
}
