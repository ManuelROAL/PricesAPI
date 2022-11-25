package com.prices.service;

import com.prices.entity.Price;
import com.prices.repository.PriceRepository;
import com.prices.response.PriceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PriceResponse consultPrice(Date appDate, Long productId, Integer brandId) {
        List<Price> listPrice = priceRepository.findPrice(appDate, productId, brandId);
        PriceResponse priceResponse = null;
        if (!listPrice.isEmpty()) {
            Price price = listPrice.get(0);
            priceResponse = modelMapper.map(price, PriceResponse.class);
        }
        return priceResponse;
    }
}
