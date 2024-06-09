package ru.ecomshop.productservice.controller.price;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ecomshop.productservice.model.dto.price.request.CreatePriceRequest;
import ru.ecomshop.productservice.model.dto.price.request.UpdatePriceRequest;
import ru.ecomshop.productservice.model.dto.price.response.PriceResponse;
import ru.ecomshop.productservice.service.price.PriceService;

import java.util.Collection;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public ResponseEntity<Collection<PriceResponse>> getAllPrices() {
        return ok(priceService.getAllPrices());
    }

    @GetMapping("/{priceId}")
    public ResponseEntity<PriceResponse> getPriceById(@PathVariable Long priceId) {
        return ok(priceService.getPriceById(priceId));
    }

    @PostMapping
    public ResponseEntity<PriceResponse> createPrice(@RequestBody CreatePriceRequest createPriceRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(priceService.createPrice(createPriceRequest));
    }

    @PutMapping("/{priceId}")
    public ResponseEntity<PriceResponse> updatePriceById(@PathVariable Long priceId,
                                                         @RequestBody UpdatePriceRequest updatePriceRequest) {
        return ok(priceService.updatePriceById(priceId, updatePriceRequest));
    }

    @DeleteMapping("/{priceId}")
    public ResponseEntity<Void> deletePriceById(@PathVariable Long priceId) {
        priceService.deletePriceById(priceId);
        return ok().build();
    }
}
