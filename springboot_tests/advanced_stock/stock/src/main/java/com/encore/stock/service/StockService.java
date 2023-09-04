package com.encore.stock.service;

import java.util.List;

import com.encore.stock.data.dto.StockDto;
import com.encore.stock.data.dto.joinDto;

public interface StockService {
    
    List<StockDto> getStockByStockCode(String stockCode);
    List<StockDto> getStockByStockCodeRagne(String code, String from_to, String end_to);

    List<joinDto> getStockByJoinDtos(String code);
}
