package com.prices.controller;

import com.prices.response.PriceResponse;
import com.prices.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/prices/{appDate}/{productId}/{brandId}")
    public ResponseEntity<?> consultPrice(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date appDate,
                                          @PathVariable Long productId, @PathVariable Integer brandId) {
        PriceResponse priceResponse = priceService.consultPrice(appDate, productId, brandId);
        if (priceResponse == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(priceResponse);
        }
    }

}
