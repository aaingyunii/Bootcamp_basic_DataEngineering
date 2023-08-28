package com.encore.stock.Service;

import com.encore.stock.data.dto.StockDto;
import java.util.List;

public interface StockService {
    List<StockDto> getStockByStockCode(String stockCode);
    List<StockDto> getStockByStockCodeRange(String code, String from_to, String end_to);
}
