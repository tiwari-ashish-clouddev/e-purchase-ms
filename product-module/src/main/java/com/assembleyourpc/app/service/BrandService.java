package com.assembleyourpc.app.service;

import com.assembleyourpc.app.dto.BrandResponseDTO;
import com.assembleyourpc.app.mapper.BrandMapper;
import com.assembleyourpc.app.model.Brand;
import com.assembleyourpc.app.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    @Transactional
    public String saveBrand(BrandResponseDTO requestResponseDTO){
        Brand brand = BrandMapper.INSTANCE.fromBrandRequestDtoToBrandObj(requestResponseDTO);
        brand.setBrandCreationDT(LocalDateTime.now());
        return Optional.of(brandRepository.save(brand)).orElseThrow(() -> new RuntimeException("Unable to Save Brand.")).getBrandName()+ " is added successfully.";
    }

    public BrandResponseDTO getBrand(Long brandId){
        return BrandMapper.INSTANCE.fromBrandObjToBrandResponseDto(brandRepository.findById(brandId).orElseThrow(() -> new RuntimeException("Unable to find Brand")));
    }

    public List<BrandResponseDTO> getListOfBrands(){
        return BrandMapper.INSTANCE.fromListOfBrandObjToListOfBrandResponseDto(brandRepository.findAll());
    }

}
