package ru.ecomshop.productservice.model.dto.productattribute.request;

public record UpdateProductAttributeRequest(
        Long productId,
        String attributeName,
        String attributeValue
) {}
