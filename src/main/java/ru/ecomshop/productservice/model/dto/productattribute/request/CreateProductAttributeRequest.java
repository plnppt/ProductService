package ru.ecomshop.productservice.model.dto.productattribute.request;

public record CreateProductAttributeRequest(
        Long productId,
        String attributeName,
        String attributeValue
) {}
