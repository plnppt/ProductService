package ru.ecomshop.productservice.model.mapper.productimage;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.ecomshop.productservice.model.dto.productimage.request.CreateProductImageRequest;
import ru.ecomshop.productservice.model.dto.productimage.request.UpdateProductImageRequest;
import ru.ecomshop.productservice.model.dto.productimage.response.ProductImageResponse;
import ru.ecomshop.productservice.model.entity.ProductImage;

@Mapper
public interface ProductImageMapper {

    @Mapping(source = "productId", target = "product.id")
    ProductImage toProductImage(CreateProductImageRequest dto);

    @Mapping(source = "productId", target = "product.id")
    void updateProductImage(UpdateProductImageRequest dto, @MappingTarget ProductImage productImage);

    @Mapping(source = "product.id", target = "productId")
    ProductImageResponse toProductImageResponse(ProductImage entity);
}
