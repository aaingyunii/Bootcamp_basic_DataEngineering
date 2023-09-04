package com.encore.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encore.stock.data.dto.StockDto;
import com.encore.stock.data.dto.joinDto;
import com.encore.stock.data.dto.responseDto;
import com.encore.stock.service.StockService;
import java.util.List;
import java.util.Map;

@RestController
public class StockController {
    
    private final StockService stockService;
    
    @Autowired
    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/stock/{code}")
    public ResponseEntity<List<StockDto>> show(@PathVariable String code){
        List<StockDto> stockDTOs = stockService.getStockByStockCode(code);
        if (stockDTOs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(stockDTOs);
        }

    }

    @GetMapping("/stock/join/{code}")
    public ResponseEntity<List<joinDto>> joinshow(@PathVariable String code){
        List<joinDto> stockDTOs = stockService.getStockByJoinDtos(code);
        if (stockDTOs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(stockDTOs);
        }

    }

    @GetMapping("/stockdate")
    public ResponseEntity<List<StockDto>> show(@RequestParam String code, String from_to, String end_to){
        List<StockDto> stockDTOs = stockService.getStockByStockCodeRagne(code, from_to, end_to);
        if (stockDTOs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(stockDTOs);
        }

    }

    @PostMapping("/stockdate")
    public ResponseEntity<List<StockDto>> postshow(@RequestBody responseDto postData){
        // System.out.println(stockcode.toString());


        List<StockDto> stockDTOs = stockService.getStockByStockCodeRagne(postData.getCode(), postData.getFrom_to(), postData.getEnd_to());
        if (stockDTOs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(stockDTOs);
        }
    }
}
