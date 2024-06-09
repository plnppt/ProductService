package ru.ecomshop.productservice.model.dto.product.response;

import ru.ecomshop.productservice.model.dto.productattribute.response.ProductAttributeResponse;
import ru.ecomshop.productservice.model.dto.productimage.response.ProductImageResponse;

import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        String description,
        String sku,
        Long categoryId,
        Long brandId,
        List<ProductAttributeResponse> attributeList,
        List<ProductImageResponse> imageList
) {}
