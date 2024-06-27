package com.assembleyourpc.app.controller;

import com.assembleyourpc.app.dto.ProductRequestDTO;
import com.assembleyourpc.app.dto.ProductResponseDTO;
import com.assembleyourpc.app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> saveProduct(@RequestBody ProductRequestDTO requestDTO){
        return ResponseEntity.ok(productService.saveProduct(requestDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getListOfProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable(value = "productId") Long productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

}
