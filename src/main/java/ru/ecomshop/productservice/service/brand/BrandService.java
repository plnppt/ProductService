package ru.ecomshop.productservice.service.brand;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ecomshop.productservice.model.dto.brand.request.CreateBrandRequest;
import ru.ecomshop.productservice.model.dto.brand.request.UpdateBrandRequest;
import ru.ecomshop.productservice.model.dto.brand.response.BrandResponse;
import ru.ecomshop.productservice.model.entity.Brand;
import ru.ecomshop.productservice.model.mapper.brand.BrandMapper;
import ru.ecomshop.productservice.repository.BrandRepository;

import java.util.Collection;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public Collection<BrandResponse> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(brandMapper::toBrandResponse)
                .toList();
    }

    public BrandResponse getBrandById(Long id) {
        var brand = processFindBrandById(id);
        return brandMapper.toBrandResponse(brand);
    }

    public BrandResponse createBrand(CreateBrandRequest createBrandRequest) {
        Brand brand = brandMapper.toBrand(createBrandRequest);
        return brandMapper.toBrandResponse(brandRepository.save(brand));
    }

    @Transactional
    public BrandResponse updateBrandById(Long brandId, UpdateBrandRequest updateBrandRequest) {
        var brand = processFindBrandById(brandId);
        brandMapper.updateBrand(updateBrandRequest, brand);
        return brandMapper.toBrandResponse(brand);
    }

    public void deleteBrandById(Long brandId) {
        var brand = processFindBrandById(brandId);
        brandRepository.delete(brand);
    }

    private Brand processFindBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Бренда по такому идентификатору не существует")
        );
    }
}
