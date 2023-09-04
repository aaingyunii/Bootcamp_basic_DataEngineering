package com.encore.stock.data.repository;

import com.encore.stock.data.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.encore.stock.data.dto.joinDto;
import java.util.ArrayList;
import java.util.List;



public interface StockRepository extends JpaRepository<Stock, String>{
    @Query("SELECT t FROM Stock t WHERE t.stockCode = :stockcode")
    List<Stock> queryByStockCode(String stockcode);


    @Query("SELECT t FROM Stock t WHERE t.stockCode = :stockcode and t.date >= :from_to and t.date <= :end_to")
    List<Stock> queryByStockCodeAndDateAndDate(String stockcode, String from_to, String end_to);

    @Query("SELECT new com.encore.stock.data.dto.joinDto( " +
           "t.stockCode, r.ISU_NM, r.MKT_TP_NM, t.date, t.open, t.high, t.low, t.close, t.volume, t.foreignExchangeRate )" +
           "FROM Stock t LEFT JOIN Master r ON t.stockCode = r.ISU_SRT_CD WHERE t.stockCode = :stockcode")
    List<joinDto> queryByStockCodeWithMaster(String stockcode);

}