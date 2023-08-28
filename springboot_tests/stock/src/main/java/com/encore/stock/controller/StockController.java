package com.encore.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.stock.Service.StockService;
import com.encore.stock.data.dto.ResponseDto;
import com.encore.stock.data.dto.StockDto;

import java.util.List;

@RestController
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/stock/{code}")
    public ResponseEntity<List<StockDto>> show(@PathVariable String code){
        List<StockDto> stockDtos = stockService.getStockByStockCode(code);
        
        if(stockDtos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(stockDtos);
        }
    }

    @PostMapping("/stockdate")
    public ResponseEntity<List<StockDto>> postShow(@RequestBody ResponseDto postData){
        List<StockDto> stockDtos = stockService.getStockByStockCodeRange(
            postData.getCode(),postData.getFrom_to(),postData.getEnd_to());

        if(stockDtos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(stockDtos);
        }
    }

    
}
