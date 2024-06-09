package ru.ecomshop.productservice.model.dto.price.request;

import ru.ecomshop.productservice.model.entity.PriceType;

import java.util.Date;

public record CreatePriceRequest(
        Long productId,
        double price,
        PriceType priceType,
        Date startDate,
        Date endDate
) {}
