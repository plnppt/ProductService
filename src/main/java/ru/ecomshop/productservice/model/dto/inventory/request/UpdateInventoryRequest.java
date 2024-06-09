package ru.ecomshop.productservice.model.dto.inventory.request;

public record UpdateInventoryRequest(
        Long productId,
        int quantity
) {}
