package ru.ecomshop.productservice.model.mapper.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.ecomshop.productservice.model.dto.product.request.CreateProductRequest;
import ru.ecomshop.productservice.model.dto.product.request.UpdateProductRequest;
import ru.ecomshop.productservice.model.dto.product.response.ProductResponse;
import ru.ecomshop.productservice.model.dto.productattribute.response.ProductAttributeResponse;
import ru.ecomshop.productservice.model.dto.productimage.response.ProductImageResponse;
import ru.ecomshop.productservice.model.entity.Product;
import ru.ecomshop.productservice.model.entity.ProductAttribute;
import ru.ecomshop.productservice.model.entity.ProductImage;

import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "brandId", target = "brand.id")
    Product toProduct(CreateProductRequest dto);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "brandId", target = "brand.id")
    void updateProduct(UpdateProductRequest dto, @MappingTarget Product product);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(target = "attributeList", expression = "java(mapAttributes(product.getAttributeList()))")
    @Mapping(target = "imageList", expression = "java(mapImages(product.getImageList()))")
    ProductResponse toProductResponse(Product product);

    // Маппинг для атрибутов
    default List<ProductAttributeResponse> mapAttributes(List<ProductAttribute> attributes) {
        return attributes.stream()
                .map(attribute -> new ProductAttributeResponse(
                        attribute.getId(),
                        attribute.getProduct().getId(),
                        attribute.getAttributeName(),
                        attribute.getAttributeValue()))
                .collect(Collectors.toList());
    }

    // Маппинг для изображений
    default List<ProductImageResponse> mapImages(List<ProductImage> images) {
        return images.stream()
                .map(image -> new ProductImageResponse(
                        image.getId(),
                        image.getProduct().getId(),
                        image.getImageUrl()))
                .collect(Collectors.toList());
    }
}
