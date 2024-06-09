package ru.ecomshop.productservice.controller.brand;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ecomshop.productservice.model.dto.brand.request.CreateBrandRequest;
import ru.ecomshop.productservice.model.dto.brand.request.UpdateBrandRequest;
import ru.ecomshop.productservice.model.dto.brand.response.BrandResponse;
import ru.ecomshop.productservice.service.brand.BrandService;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<Collection<BrandResponse>> getAllBrands() {
        return ok(brandService.getAllBrands());
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable Long brandId) {
        return ok(brandService.getBrandById(brandId));
    }

    @PostMapping
    public ResponseEntity<BrandResponse> createBrand(@RequestBody CreateBrandRequest createBrandRequest) {
        return ResponseEntity
                .status(CREATED)
                .body(brandService.createBrand(createBrandRequest));
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<BrandResponse> updateBrandById(@PathVariable Long brandId,
                                                         @RequestBody UpdateBrandRequest updateBrandRequest) {
        return ok(brandService.updateBrandById(brandId, updateBrandRequest));
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> deleteBrandById(@PathVariable Long brandId) {
        brandService.deleteBrandById(brandId);
        return ok().build();
    }
}
