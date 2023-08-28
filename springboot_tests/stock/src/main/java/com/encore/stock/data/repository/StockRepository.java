package com.encore.stock.data.repository;

import com.encore.stock.data.entity.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, String>{
    @Query("SELECT t FROM Stock t WHERE t.stockCode = :stockCode")
    List<Stock> queryByStockCode(String stockCode);

    @Query("SELECT t FROM Stock t WHERE t.stockCode = :stockCode and t.date >= :from_to and t.date <= :end_to")
    List<Stock> queryByStockCodeAndDateAndDate(String stockCode, String from_to, String end_to);
}

