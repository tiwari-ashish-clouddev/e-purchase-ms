package com.assembleyourpc.app.service;

import com.assembleyourpc.app.dto.ProductRequestDTO;
import com.assembleyourpc.app.dto.ProductResponseDTO;
import com.assembleyourpc.app.mapper.ProductMapper;
import com.assembleyourpc.app.model.Brand;
import com.assembleyourpc.app.model.Category;
import com.assembleyourpc.app.model.Product;
import com.assembleyourpc.app.model.Stock;
import com.assembleyourpc.app.repository.ProductRepository;
import com.assembleyourpc.app.utils.ProductModuleUtil;
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
    private final ProductModuleUtil util;

    @Transactional
    public String saveProduct(ProductRequestDTO requestDTO){

        Product product = util.getProductObjFromRequestDTO(requestDTO);

        Brand brand =  util.getBrandById(requestDTO.brandId());

        Category category = util.getCategoryById(requestDTO.categoryId());

        product.setBrand(brand);
        product.setCategory(category);
        LocalDateTime productEntryDT =  LocalDateTime.now();
        product.setProductCreationDT(productEntryDT);
        product.setProductLastUpdateDT(productEntryDT);

        Stock stock = new Stock();
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

    @Transactional
    public String updateProductByItsID(Long productId, ProductRequestDTO requestDTO) {
        Product product = util.getProductById(productId);

        product.setBrand(util.getBrandById(requestDTO.brandId()));
        product.setCategory(util.getCategoryById(requestDTO.categoryId()));
        product.setProductDesc(requestDTO.productDesc());
        product.setProductName(requestDTO.productName());
        product.setProductTitle(requestDTO.productTitle());
        product.setProductPricePerUnit(requestDTO.productPricePerUnit());

        Stock stock = product.getStock();
        stock.setProductQuantity(requestDTO.productQuantity());
        product.setStock(stock);

        product.setProductLastUpdateDT(LocalDateTime.now());
        return "Product : "+productRepository.saveAndFlush(product).getProductName()+" is updated  successfully.";
    }

    @Transactional
    public String deleteProductById(Long productId) {
        Product product = util.getProductById(productId);
        productRepository.delete(util.getProductById(productId));
        return product.getProductName()+" is removed successfully.";
    }
}
