package ru.ecomshop.productservice.controller.productattribute;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ecomshop.productservice.model.dto.productattribute.request.CreateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productattribute.request.UpdateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productattribute.response.ProductAttributeResponse;
import ru.ecomshop.productservice.service.productattribute.ProductAttributeService;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/product-attributes")
@RequiredArgsConstructor
public class ProductAttributeController {

    private final ProductAttributeService productAttributeService;

    @GetMapping
    public ResponseEntity<Collection<ProductAttributeResponse>> getAllProductAttributes() {
        return ok(productAttributeService.getAllProductAttributes());
    }

    @GetMapping("/{productAttributeId}")
    public ResponseEntity<ProductAttributeResponse> getProductAttributeById(@PathVariable Long productAttributeId) {
        return ok(productAttributeService.getProductAttributeById(productAttributeId));
    }

    @PostMapping
    public ResponseEntity<ProductAttributeResponse> createProductAttribute(@RequestBody CreateProductAttributeRequest createProductAttributeRequest) {
        return ResponseEntity
                .status(CREATED)
                .body(productAttributeService.createProductAttribute(createProductAttributeRequest));
    }

    @PutMapping("/{productAttributeId}")
    public ResponseEntity<ProductAttributeResponse> updateProductAttributeById(@PathVariable Long productAttributeId,
                                                                               @RequestBody UpdateProductAttributeRequest updateProductAttributeRequest) {
        return ok(productAttributeService.updateProductAttributeById(productAttributeId, updateProductAttributeRequest));
    }

    @DeleteMapping("/{productAttributeId}")
    public ResponseEntity<Void> deleteProductAttributeById(@PathVariable Long productAttributeId) {
        productAttributeService.deleteProductAttributeById(productAttributeId);
        return ok().build();
    }
}
