package ru.ecomshop.productservice.service.product;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ecomshop.productservice.model.dto.product.request.CreateProductRequest;
import ru.ecomshop.productservice.model.dto.product.request.UpdateProductRequest;
import ru.ecomshop.productservice.model.dto.product.response.ProductResponse;
import ru.ecomshop.productservice.model.entity.Inventory;
import ru.ecomshop.productservice.model.entity.Product;
import ru.ecomshop.productservice.model.mapper.product.ProductMapper;
import ru.ecomshop.productservice.repository.InventoryRepository;
import ru.ecomshop.productservice.repository.ProductRepository;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;
    private final ProductMapper productMapper;

    public Collection<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    public ProductResponse getProductById(Long id) {
        var product = processFindProductById(id);
        return productMapper.toProductResponse(product);
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = productMapper.toProduct(createProductRequest);
        // Установим обратные ссылки для вложенных сущностей
        product.getAttributeList().forEach(attribute -> attribute.setProduct(product));
        product.getImageList().forEach(image -> image.setProduct(product));
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Transactional
    public ProductResponse updateProductById(Long productId, UpdateProductRequest updateProductRequest) {
        var product = processFindProductById(productId);
        productMapper.updateProduct(updateProductRequest, product);
        // Установим обратные ссылки для вложенных сущностей
        product.getAttributeList().forEach(attribute -> attribute.setProduct(product));
        product.getImageList().forEach(image -> image.setProduct(product));
        return productMapper.toProductResponse(product);
    }

    @Transactional
    //TODO: не здесь это должно быть
    public void decreaseProductQuantity(Long productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("Товар с таким идентификатором не найден на складе"));
        if (inventory.getQuantity() < quantity) {
            throw new IllegalArgumentException("Недостаточно товара на складе");
        }
        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventoryRepository.save(inventory);
    }

    public void deleteProductById(Long productId) {
        var product = processFindProductById(productId);
        productRepository.delete(product);
    }

    private Product processFindProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Продукт по такому идентификатору не существует")
        );
    }
}
