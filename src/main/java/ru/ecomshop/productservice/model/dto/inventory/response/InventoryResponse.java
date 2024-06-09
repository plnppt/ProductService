package ru.ecomshop.productservice.model.dto.inventory.response;

import java.util.Date;

public record InventoryResponse(
        Long id,
        Long productId,
        int quantity,
        Date lastUpdated
) {}
