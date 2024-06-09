package ru.ecomshop.productservice.model.mapper.brand;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.ecomshop.productservice.model.dto.brand.request.CreateBrandRequest;
import ru.ecomshop.productservice.model.dto.brand.request.UpdateBrandRequest;
import ru.ecomshop.productservice.model.dto.brand.response.BrandResponse;
import ru.ecomshop.productservice.model.entity.Brand;

@Mapper
public interface BrandMapper {

    Brand toBrand(CreateBrandRequest dto);

    void updateBrand(UpdateBrandRequest dto, @MappingTarget Brand brand);

    BrandResponse toBrandResponse(Brand entity);
}
