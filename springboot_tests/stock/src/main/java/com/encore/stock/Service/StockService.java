package com.encore.stock.Service;

import com.encore.stock.data.dto.StockDto;
import java.util.List;

public interface StockService {
    List<StockDto> getStockByStockCode(String stockCode);

}
