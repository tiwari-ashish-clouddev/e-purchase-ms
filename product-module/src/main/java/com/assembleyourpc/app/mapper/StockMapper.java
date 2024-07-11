package com.assembleyourpc.app.mapper;

import com.assembleyourpc.app.dto.StockRequestDTO;
import com.assembleyourpc.app.dto.StockResponseDTO;
import com.assembleyourpc.app.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StockMapper {

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    @Mapping(target = "stockId", ignore = true)
    @Mapping(target = "stockCreationDT", ignore = true)
    @Mapping(target = "product", ignore = true)
    Stock fromStockRequestDtoToStockObj(StockRequestDTO stockRequestDTO);

    @Mapping(source = "stock.product.productName", target = "productName")
    StockResponseDTO fromStockObjToStockResponseDto(Stock stock);

    List<StockResponseDTO> fromListOfStockObjToListOfStockResponseDto(List<Stock> stocks);
}
