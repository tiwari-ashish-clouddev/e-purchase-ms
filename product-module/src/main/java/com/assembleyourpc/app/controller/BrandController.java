package com.assembleyourpc.app.controller;

import com.assembleyourpc.app.dto.BrandRequestDTO;
import com.assembleyourpc.app.dto.BrandResponseDTO;
import com.assembleyourpc.app.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
@Tag(name = "Brand", description = "Endpoints related to Brand")
public class BrandController {

    private final BrandService brandService;

    @PostMapping("/add")
    @Operation(summary = "This will add new Brand Info in System.")
    public ResponseEntity<String> addBrand(@Validated @RequestBody BrandRequestDTO requestDTO) {
        return new ResponseEntity<>(brandService.saveBrand(requestDTO), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "This will get all Brands from System.")
    public ResponseEntity<List<BrandResponseDTO>> listOfBrands() {
        return ResponseEntity.ok(brandService.getListOfBrands());
    }

    @GetMapping("/{brandId}")
    @Operation(summary = "This will get Brand Information By its Id from System.")
    public ResponseEntity<BrandResponseDTO> getBrandById(@PathVariable("brandId") Long brandId) {
        return ResponseEntity.ok(brandService.getBrand(brandId));
    }
}
