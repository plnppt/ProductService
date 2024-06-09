package ru.ecomshop.productservice.model.dto.brand.request;

public record CreateBrandRequest(
        String name,
        String description
) {}
