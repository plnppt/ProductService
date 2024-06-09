package ru.ecomshop.productservice.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ecomshop.productservice.model.dto.product.request.CreateProductRequest;
import ru.ecomshop.productservice.model.dto.product.request.UpdateProductRequest;
import ru.ecomshop.productservice.model.dto.product.response.ProductResponse;
import ru.ecomshop.productservice.service.product.ProductService;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Collection<ProductResponse>> getAllProducts() {
        return ok(productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId) {
        return ok(productService.getProductById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity
                .status(CREATED)
                .body(productService.createProduct(createProductRequest));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable Long productId,
                                                             @RequestBody UpdateProductRequest updateProductRequest) {
        return ok(productService.updateProductById(productId, updateProductRequest));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return ok().build();
    }

    @PostMapping("/decrease-quantity")
    public ResponseEntity<Void> decreaseProductQuantity(@RequestParam Long productId, @RequestParam int quantity) {
        productService.decreaseProductQuantity(productId, quantity);
        return ResponseEntity.ok().build();
    }
}
