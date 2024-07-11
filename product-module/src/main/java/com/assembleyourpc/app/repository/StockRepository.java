package com.assembleyourpc.app.repository;

import com.assembleyourpc.app.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    @Query(nativeQuery = true, value = "SELECT s.* FROM tblStock s INNER JOIN tblProduct p ON p.stockId = s.stockId WHERE p.productName =?1")
    Optional<Stock> getStockInfoByProductName(String productName);

    @Query(nativeQuery = true, value = "SELECT s.* FROM tblStock s INNER JOIN tblProduct p ON p.stockId = s.stockId WHERE p.productId =?1")
    Optional<Stock> getStockInfoByProductId(Long productId);

}
