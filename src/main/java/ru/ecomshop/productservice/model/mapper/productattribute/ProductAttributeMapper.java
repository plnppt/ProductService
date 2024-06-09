package ru.ecomshop.productservice.model.mapper.productattribute;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.ecomshop.productservice.model.dto.productattribute.request.CreateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productattribute.request.UpdateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productattribute.response.ProductAttributeResponse;
import ru.ecomshop.productservice.model.entity.ProductAttribute;

@Mapper(componentModel = "spring")
public interface ProductAttributeMapper {

    @Mapping(source = "productId", target = "product.id")
    ProductAttribute toProductAttribute(CreateProductAttributeRequest dto);

    @Mapping(source = "productId", target = "product.id")
    void updateProductAttribute(UpdateProductAttributeRequest dto, @MappingTarget ProductAttribute productAttribute);

    @Mapping(source = "product.id", target = "productId")
    ProductAttributeResponse toProductAttributeResponse(ProductAttribute entity);
}
