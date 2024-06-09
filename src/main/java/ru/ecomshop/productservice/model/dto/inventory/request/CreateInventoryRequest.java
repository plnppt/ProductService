package ru.ecomshop.productservice.model.dto.inventory.request;

public record CreateInventoryRequest(
        Long productId,
        int quantity
) {}
