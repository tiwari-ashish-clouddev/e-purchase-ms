package com.assembleyourpc.app.mapper;

import com.assembleyourpc.app.dto.*;
import com.assembleyourpc.app.model.Brand;
import com.assembleyourpc.app.model.Category;
import com.assembleyourpc.app.model.Product;
import com.assembleyourpc.app.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "stock", ignore = true)
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "productCreationDT", ignore = true)
    @Mapping(target = "productLastUpdateDT", ignore = true)
    Product fromProductRequestDtoToProductObj(ProductRequestDTO productRequestDTO);

    @Mapping(source = "product.brand", target = "brand", qualifiedByName = "fromBrandToBrandResponseDTO")
    @Mapping(source = "product.category", target = "category", qualifiedByName = "fromCategoryToCategoryResponseDTO")
    @Mapping(source = "product.stock", target = "stock", qualifiedByName = "fromStockToStockResponseDTO")
    ProductResponseDTO fromProductObjToProductResponseDto(Product product);

    @Named("fromBrandToBrandResponseDTO")
    default BrandResponseDTO fromBrandToBrandResponseDTO(Brand brand) {
        return BrandMapper.INSTANCE.fromBrandObjToBrandResponseDto(brand);
    }

    @Named("fromCategoryToCategoryResponseDTO")
    default CategoryResponseDTO fromCategoryToCategoryResponseDTO(Category category) {
        return CategoryMapper.INSTANCE.fromCategoryObjToCategoryResponseDto(category);
    }

    @Named("fromStockToStockResponseDTO")
    default StockResponseDTO fromStockToStockResponseDTO(Stock stock) {
        return StockMapper.INSTANCE.fromStockObjToStockResponseDto(stock);
    }

    List<ProductResponseDTO> fromListOfProductObjToListOfProductResponseDto(List<Product> products);

}
