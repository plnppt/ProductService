package ru.ecomshop.productservice.service.price;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ecomshop.productservice.model.dto.price.request.CreatePriceRequest;
import ru.ecomshop.productservice.model.dto.price.request.UpdatePriceRequest;
import ru.ecomshop.productservice.model.dto.price.response.PriceResponse;
import ru.ecomshop.productservice.model.entity.Price;
import ru.ecomshop.productservice.model.mapper.price.PriceMapper;
import ru.ecomshop.productservice.repository.PriceRepository;

import java.util.Collection;

@Service
@AllArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public Collection<PriceResponse> getAllPrices() {
        return priceRepository.findAll().stream()
                .map(priceMapper::toPriceResponse)
                .toList();
    }

    public PriceResponse getPriceById(Long id) {
        var price = processFindPriceById(id);
        return priceMapper.toPriceResponse(price);
    }

    public PriceResponse createPrice(CreatePriceRequest createPriceRequest) {
        Price price = priceMapper.toPrice(createPriceRequest);
        return priceMapper.toPriceResponse(priceRepository.save(price));
    }

    @Transactional
    public PriceResponse updatePriceById(Long priceId, UpdatePriceRequest updatePriceRequest) {
        var price = processFindPriceById(priceId);
        priceMapper.updatePrice(updatePriceRequest, price);
        return priceMapper.toPriceResponse(price);
    }

    public void deletePriceById(Long priceId) {
        var price = processFindPriceById(priceId);
        priceRepository.delete(price);
    }

    private Price processFindPriceById(Long id) {
        return priceRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Цены товара по такому идентификатору не существует")
        );
    }
}
