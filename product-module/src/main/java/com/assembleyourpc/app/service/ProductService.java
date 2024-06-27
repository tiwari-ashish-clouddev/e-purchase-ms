package com.assembleyourpc.app.service;

import com.assembleyourpc.app.dto.ProductRequestDTO;
import com.assembleyourpc.app.dto.ProductResponseDTO;
import com.assembleyourpc.app.mapper.ProductMapper;
import com.assembleyourpc.app.model.Brand;
import com.assembleyourpc.app.model.Category;
import com.assembleyourpc.app.model.Product;
import com.assembleyourpc.app.model.Stock;
import com.assembleyourpc.app.repository.BrandRepository;
import com.assembleyourpc.app.repository.CategoryRepository;
import com.assembleyourpc.app.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public String saveProduct(ProductRequestDTO requestDTO){

        Product product = ProductMapper.INSTANCE.fromProductRequestDtoToProductObj(requestDTO);

        Brand brand =  brandRepository.findById(requestDTO.brandId()).orElseThrow(() -> new RuntimeException("Brand is not found."));

        Category category = categoryRepository.findById(requestDTO.categoryId()).orElseThrow(() -> new RuntimeException("Category is not found."));

        product.setBrand(brand);
        product.setCategory(category);
        product.setProductCreationDT(LocalDateTime.now());

        Stock stock = new Stock();
//        stock.setProduct(product);
        stock.setProductQuantity(requestDTO.productQuantity());
        stock.setStockCreationDT(LocalDateTime.now());

        product.setStock(stock);

        return Optional.of( productRepository.save(product)).orElseThrow(() -> new RuntimeException("Unable to Save Category.")).getProductName() + " is added successfully.";
    }

    public List<ProductResponseDTO> getListOfProducts(){
        return ProductMapper.INSTANCE.fromListOfProductObjToListOfProductResponseDto(productRepository.findAll());
    }

    public ProductResponseDTO getProductById(Long productId){
        return ProductMapper.INSTANCE.fromProductObjToProductResponseDto(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found.")));
    }

}
