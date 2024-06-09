package ru.ecomshop.productservice.model.mapper.price;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.ecomshop.productservice.model.dto.price.request.CreatePriceRequest;
import ru.ecomshop.productservice.model.dto.price.request.UpdatePriceRequest;
import ru.ecomshop.productservice.model.dto.price.response.PriceResponse;
import ru.ecomshop.productservice.model.entity.Price;


@Mapper
public interface PriceMapper {

    @Mapping(source = "productId", target = "product.id")
    Price toPrice(CreatePriceRequest dto);

    @Mapping(source = "productId", target = "product.id")
    void updatePrice(UpdatePriceRequest dto, @MappingTarget Price price);

    @Mapping(source = "product.id", target = "productId")
    PriceResponse toPriceResponse(Price entity);
}
