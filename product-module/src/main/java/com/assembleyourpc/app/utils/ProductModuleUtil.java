package com.assembleyourpc.app.utils;

import com.assembleyourpc.app.dto.ProductRequestDTO;
import com.assembleyourpc.app.mapper.ProductMapper;
import com.assembleyourpc.app.model.Brand;
import com.assembleyourpc.app.model.Category;
import com.assembleyourpc.app.model.Product;
import com.assembleyourpc.app.repository.BrandRepository;
import com.assembleyourpc.app.repository.CategoryRepository;
import com.assembleyourpc.app.repository.ProductRepository;
import com.assembleyourpc.app.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductModuleUtil {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final StockRepository stockRepository;


    public Brand getBrandById(Long brandId){
        return brandRepository
                .findById(brandId)
                .orElseThrow(() -> new RuntimeException("Brand is not found."));
    }

    public Category getCategoryById(Long categoryId){
        return categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category is not found."));
    }

    public Product getProductObjFromRequestDTO(ProductRequestDTO requestDTO){
        return ProductMapper.INSTANCE.fromProductRequestDtoToProductObj(requestDTO);
    }

    public Product getProductById(Long productId){
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product Entry is not found."));
    }
}
