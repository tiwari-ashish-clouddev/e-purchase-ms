package com.assembleyourpc.app.service;

import com.assembleyourpc.app.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

}
