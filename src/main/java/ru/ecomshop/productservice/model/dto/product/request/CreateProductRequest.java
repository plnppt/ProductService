package ru.ecomshop.productservice.model.dto.product.request;

import ru.ecomshop.productservice.model.dto.productattribute.request.CreateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productimage.request.CreateProductImageRequest;

import java.util.List;

public record CreateProductRequest(
        String name,
        String description,
        String sku,
        Long categoryId,
        Long brandId,
        List<CreateProductAttributeRequest> attributeList,
        List<CreateProductImageRequest> imageList
) {}
