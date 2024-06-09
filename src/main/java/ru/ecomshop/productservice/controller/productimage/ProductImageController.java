package ru.ecomshop.productservice.controller.productimage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ecomshop.productservice.model.dto.productimage.request.CreateProductImageRequest;
import ru.ecomshop.productservice.model.dto.productimage.request.UpdateProductImageRequest;
import ru.ecomshop.productservice.model.dto.productimage.response.ProductImageResponse;
import ru.ecomshop.productservice.service.productimage.ProductImageService;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/product-images")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService productImageService;

    @GetMapping
    public ResponseEntity<Collection<ProductImageResponse>> getAllProductImages() {
        return ok(productImageService.getAllProductImages());
    }

    @GetMapping("/{productImageId}")
    public ResponseEntity<ProductImageResponse> getProductImageById(@PathVariable Long productImageId) {
        return ok(productImageService.getProductImageById(productImageId));
    }

    @PostMapping
    public ResponseEntity<ProductImageResponse> createProductImage(@RequestBody CreateProductImageRequest createProductImageRequest) {
        return ResponseEntity
                .status(CREATED)
                .body(productImageService.createProductImage(createProductImageRequest));
    }

    @PutMapping("/{productImageId}")
    public ResponseEntity<ProductImageResponse> updateProductImageById(@PathVariable Long productImageId,
                                                                       @RequestBody UpdateProductImageRequest updateProductImageRequest) {
        return ok(productImageService.updateProductImageById(productImageId, updateProductImageRequest));
    }

    @DeleteMapping("/{productImageId}")
    public ResponseEntity<Void> deleteProductImageById(@PathVariable Long productImageId) {
        productImageService.deleteProductImageById(productImageId);
        return ok().build();
    }
}
