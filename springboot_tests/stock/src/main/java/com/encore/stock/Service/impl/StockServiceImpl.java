package com.encore.stock.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.stock.Service.StockService;
import com.encore.stock.data.dto.StockDto;
import com.encore.stock.data.repository.StockRepository;
import com.encore.stock.data.entity.Stock;

@Service
public class StockServiceImpl implements StockService {
    private StockRepository stockRepository;
    
    @Autowired
    public StockServiceImpl(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    @Override
    public List<StockDto> getStockByStockCode(String stockCode) {
        List<Stock> stocks = stockRepository.queryByStockCode(stockCode);
        return stocks.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StockDto> getStockByStockCodeRange(String code, String from_to, String end_to){
        List<Stock> stocks = stockRepository.queryByStockCodeAndDateAndDate(code, from_to, end_to);
        return stocks.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private StockDto convertToDTO(Stock stock){
        StockDto dto = new StockDto();
        dto.setStockCode(stock.getStockCode());
        dto.setDate(stock.getDate());
        dto.setOpen(stock.getOpen());
        dto.setHigh(stock.getHigh());
        dto.setLow(stock.getLow());
        dto.setClose(stock.getClose());
        dto.setVolume(stock.getVolume());
        dto.setForeignExchangeRate(stock.getForeignExchangeRate());
        return dto;
    }


}