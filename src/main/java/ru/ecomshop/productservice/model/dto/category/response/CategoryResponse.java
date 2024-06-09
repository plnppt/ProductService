package ru.ecomshop.productservice.model.dto.category.response;

import java.util.List;

public record CategoryResponse(
        Long id,
        String name,
        String description,
        Long parentId,
        List<Long> subcategoryIds
) {}
