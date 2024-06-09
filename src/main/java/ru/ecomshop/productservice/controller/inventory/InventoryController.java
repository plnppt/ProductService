package ru.ecomshop.productservice.controller.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ecomshop.productservice.model.dto.inventory.request.CreateInventoryRequest;
import ru.ecomshop.productservice.model.dto.inventory.request.UpdateInventoryRequest;
import ru.ecomshop.productservice.model.dto.inventory.response.InventoryResponse;
import ru.ecomshop.productservice.service.inventory.InventoryService;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Collection<InventoryResponse>> getAllInventories() {
        return ok(inventoryService.getAllInventories());
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<InventoryResponse> getInventoryById(@PathVariable Long inventoryId) {
        return ok(inventoryService.getInventoryById(inventoryId));
    }

    @PostMapping
    public ResponseEntity<InventoryResponse> createInventory(@RequestBody CreateInventoryRequest createInventoryRequest) {
        return ResponseEntity
                .status(CREATED)
                .body(inventoryService.createInventory(createInventoryRequest));
    }

    @PutMapping("/{inventoryId}")
    public ResponseEntity<InventoryResponse> updateInventoryById(@PathVariable Long inventoryId,
                                                                 @RequestBody UpdateInventoryRequest updateInventoryRequest) {
        return ok(inventoryService.updateInventoryById(inventoryId, updateInventoryRequest));
    }

    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<Void> deleteInventoryById(@PathVariable Long inventoryId) {
        inventoryService.deleteInventoryById(inventoryId);
        return ok().build();
    }
}
