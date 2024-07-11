package com.assembleyourpc.app.service;

import com.assembleyourpc.app.dto.StockResponseDTO;
import com.assembleyourpc.app.mapper.StockMapper;
import com.assembleyourpc.app.model.Stock;
import com.assembleyourpc.app.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public StockResponseDTO getStockByStockId(Long stockId){
        Stock stock = stockRepository
                .findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock ID is not found."));
        return StockMapper.INSTANCE.fromStockObjToStockResponseDto(stock);
    }

    public StockResponseDTO getStockByProductName(String productName){
        Stock stock = stockRepository
                .getStockInfoByProductName(productName)
                .orElseThrow(() -> new RuntimeException("Stock Entry for Product is not found."));

        return StockMapper.INSTANCE.fromStockObjToStockResponseDto(stock);
    }

}
