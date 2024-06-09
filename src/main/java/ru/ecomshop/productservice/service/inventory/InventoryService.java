package ru.ecomshop.productservice.service.inventory;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ecomshop.productservice.model.dto.inventory.request.CreateInventoryRequest;
import ru.ecomshop.productservice.model.dto.inventory.request.UpdateInventoryRequest;
import ru.ecomshop.productservice.model.dto.inventory.response.InventoryResponse;
import ru.ecomshop.productservice.model.entity.Inventory;
import ru.ecomshop.productservice.model.mapper.inventory.InventoryMapper;
import ru.ecomshop.productservice.repository.InventoryRepository;

import java.util.Collection;
import java.util.Date;

@Service
@AllArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public Collection<InventoryResponse> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(inventoryMapper::toInventoryResponse)
                .toList();
    }

    public InventoryResponse getInventoryById(Long id) {
        var inventory = processFindInventoryById(id);
        return inventoryMapper.toInventoryResponse(inventory);
    }

    public InventoryResponse createInventory(CreateInventoryRequest createInventoryRequest) {
        Inventory inventory = inventoryMapper.toInventory(createInventoryRequest);
        inventory.setLastUpdated(new Date());
        return inventoryMapper.toInventoryResponse(inventoryRepository.save(inventory));
    }

    @Transactional
    public InventoryResponse updateInventoryById(Long inventoryId, UpdateInventoryRequest updateInventoryRequest) {
        var inventory = processFindInventoryById(inventoryId);
        inventoryMapper.updateInventory(updateInventoryRequest, inventory);
        inventory.setLastUpdated(new Date());
        return inventoryMapper.toInventoryResponse(inventory);
    }

    public void deleteInventoryById(Long inventoryId) {
        var inventory = processFindInventoryById(inventoryId);
        inventoryRepository.delete(inventory);
    }

    private Inventory processFindInventoryById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Учета товара по такому идентификатору не существует")
        );
    }
}
