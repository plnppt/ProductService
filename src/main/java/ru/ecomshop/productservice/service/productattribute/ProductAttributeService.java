package ru.ecomshop.productservice.service.productattribute;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ecomshop.productservice.model.dto.productattribute.request.CreateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productattribute.request.UpdateProductAttributeRequest;
import ru.ecomshop.productservice.model.dto.productattribute.response.ProductAttributeResponse;
import ru.ecomshop.productservice.model.entity.ProductAttribute;
import ru.ecomshop.productservice.model.mapper.productattribute.ProductAttributeMapper;
import ru.ecomshop.productservice.repository.ProductAttributeRepository;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttributeMapper productAttributeMapper;

    public Collection<ProductAttributeResponse> getAllProductAttributes() {
        return productAttributeRepository.findAll().stream()
                .map(productAttributeMapper::toProductAttributeResponse)
                .toList();
    }

    public ProductAttributeResponse getProductAttributeById(Long id) {
        var productAttribute = processFindProductAttributeById(id);
        return productAttributeMapper.toProductAttributeResponse(productAttribute);
    }

    public ProductAttributeResponse createProductAttribute(CreateProductAttributeRequest createProductAttributeRequest) {
        ProductAttribute productAttribute = productAttributeMapper.toProductAttribute(createProductAttributeRequest);
        return productAttributeMapper.toProductAttributeResponse(productAttributeRepository.save(productAttribute));
    }

    @Transactional
    public ProductAttributeResponse updateProductAttributeById(Long productAttributeId, UpdateProductAttributeRequest updateProductAttributeRequest) {
        var productAttribute = processFindProductAttributeById(productAttributeId);
        productAttributeMapper.updateProductAttribute(updateProductAttributeRequest, productAttribute);
        return productAttributeMapper.toProductAttributeResponse(productAttribute);
    }

    public void deleteProductAttributeById(Long productAttributeId) {
        var productAttribute = processFindProductAttributeById(productAttributeId);
        productAttributeRepository.delete(productAttribute);
    }

    private ProductAttribute processFindProductAttributeById(Long id) {
        return productAttributeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Атрибут продукта по такому идентификатору не существует")
        );
    }
}
