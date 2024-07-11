package com.assembleyourpc.app.mapper;

import com.assembleyourpc.app.dto.BrandRequestDTO;
import com.assembleyourpc.app.dto.BrandResponseDTO;
import com.assembleyourpc.app.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    BrandResponseDTO fromBrandObjToBrandResponseDto(Brand brand);

    List<BrandResponseDTO> fromListOfBrandObjToListOfBrandResponseDto(List<Brand> brands);

    @Mapping(target = "brandId", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "brandCreationDT", ignore = true)
    Brand fromBrandRequestDtoToBrandObj(BrandRequestDTO requestDTO);
}
