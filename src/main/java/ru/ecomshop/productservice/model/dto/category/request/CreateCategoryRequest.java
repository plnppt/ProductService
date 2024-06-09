package ru.ecomshop.productservice.model.dto.category.request;

public record CreateCategoryRequest(
        String name,
        String description,
        Long parentId
) {}
