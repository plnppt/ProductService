package ru.ecomshop.productservice.model.dto.price.response;

import ru.ecomshop.productservice.model.entity.PriceType;

import java.util.Date;

public record PriceResponse(
        Long id,
        Long productId,
        double price,
        PriceType priceType,
        Date startDate,
        Date endDate
) {}
