package ru.ecomshop.productservice.model.dto.productimage.request;

public record UpdateProductImageRequest(
        Long productId,
        String imageUrl
) {}
