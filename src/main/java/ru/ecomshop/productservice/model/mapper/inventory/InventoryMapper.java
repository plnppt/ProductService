package ru.ecomshop.productservice.model.mapper.inventory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.ecomshop.productservice.model.dto.inventory.request.CreateInventoryRequest;
import ru.ecomshop.productservice.model.dto.inventory.request.UpdateInventoryRequest;
import ru.ecomshop.productservice.model.dto.inventory.response.InventoryResponse;
import ru.ecomshop.productservice.model.entity.Inventory;


@Mapper
public interface InventoryMapper {

    @Mapping(source = "productId", target = "product.id")
    Inventory toInventory(CreateInventoryRequest dto);

    @Mapping(source = "productId", target = "product.id")
    void updateInventory(UpdateInventoryRequest dto, @MappingTarget Inventory inventory);

    @Mapping(source = "product.id", target = "productId")
    InventoryResponse toInventoryResponse(Inventory entity);
}
