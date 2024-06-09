package ru.ecomshop.productservice.model.dto.productimage.request;

public record CreateProductImageRequest(
        Long productId,
        String imageUrl
) {}
