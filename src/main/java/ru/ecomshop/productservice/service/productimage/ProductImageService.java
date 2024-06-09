package ru.ecomshop.productservice.service.productimage;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ecomshop.productservice.model.dto.productimage.request.CreateProductImageRequest;
import ru.ecomshop.productservice.model.dto.productimage.request.UpdateProductImageRequest;
import ru.ecomshop.productservice.model.dto.productimage.response.ProductImageResponse;
import ru.ecomshop.productservice.model.entity.ProductImage;
import ru.ecomshop.productservice.model.mapper.productimage.ProductImageMapper;
import ru.ecomshop.productservice.repository.ProductImageRepository;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductImageMapper productImageMapper;

    public Collection<ProductImageResponse> getAllProductImages() {
        return productImageRepository.findAll().stream()
                .map(productImageMapper::toProductImageResponse)
                .toList();
    }

    public ProductImageResponse getProductImageById(Long id) {
        var productImage = processFindProductImageById(id);
        return productImageMapper.toProductImageResponse(productImage);
    }

    public ProductImageResponse createProductImage(CreateProductImageRequest createProductImageRequest) {
        ProductImage productImage = productImageMapper.toProductImage(createProductImageRequest);
        return productImageMapper.toProductImageResponse(productImageRepository.save(productImage));
    }

    @Transactional
    public ProductImageResponse updateProductImageById(Long productImageId, UpdateProductImageRequest updateProductImageRequest) {
        var productImage = processFindProductImageById(productImageId);
        productImageMapper.updateProductImage(updateProductImageRequest, productImage);
        return productImageMapper.toProductImageResponse(productImage);
    }

    public void deleteProductImageById(Long productImageId) {
        var productImage = processFindProductImageById(productImageId);
        productImageRepository.delete(productImage);
    }

    private ProductImage processFindProductImageById(Long id) {
        return productImageRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Изображение продукта по такому идентификатору не существует")
        );
    }
}
