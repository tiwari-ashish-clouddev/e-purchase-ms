package com.assembleyourpc.app.controller;

import com.assembleyourpc.app.service.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
@AllArgsConstructor
@Tag(name = "Stock", description = "Endpoints related to Stock")
public class StockController {

    private final StockService stockService;

}
