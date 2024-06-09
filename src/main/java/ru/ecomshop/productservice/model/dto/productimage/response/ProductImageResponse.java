package ru.ecomshop.productservice.model.dto.productimage.response;

public record ProductImageResponse(
        Long id,
        Long productId,
        String imageUrl
) {}
