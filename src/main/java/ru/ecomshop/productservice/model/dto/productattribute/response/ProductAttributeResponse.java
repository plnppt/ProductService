package ru.ecomshop.productservice.model.dto.productattribute.response;

public record ProductAttributeResponse(
        Long id,
        Long productId,
        String attributeName,
        String attributeValue
) {}
