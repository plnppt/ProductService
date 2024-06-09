package ru.ecomshop.productservice.model.dto.category.request;

public record UpdateCategoryRequest(
        String name,
        String description,
        Long parentId
) {}
