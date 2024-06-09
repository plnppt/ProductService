package ru.ecomshop.productservice.model.dto.product.request;

import ru.ecomshop.productservice.model.dto.productattribute.request.UpdateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productimage.request.UpdateProductImageRequest;

import java.util.List;

public record UpdateProductRequest(
        String name,
        String description,
        String sku,
        Long categoryId,
        Long brandId,
        List<UpdateProductAttributeRequest> attributeList,
        List<UpdateProductImageRequest> imageList
) {}
