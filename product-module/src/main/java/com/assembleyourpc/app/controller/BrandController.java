package com.assembleyourpc.app.controller;

import com.assembleyourpc.app.dto.BrandResponseDTO;
import com.assembleyourpc.app.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping("/add")
    public ResponseEntity<String> addBrand(@Validated @RequestBody BrandResponseDTO requestResponseDTO) {
        return new ResponseEntity<>(brandService.saveBrand(requestResponseDTO), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BrandResponseDTO>> listOfBrands() {
        return ResponseEntity.ok(brandService.getListOfBrands());
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<BrandResponseDTO> getBrandById(@PathVariable("brandId") Long brandId) {
        return ResponseEntity.ok(brandService.getBrand(brandId));
    }
}
