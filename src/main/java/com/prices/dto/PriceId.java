package com.prices.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PriceId implements Serializable {

    private Integer priceList;

    private Long productId;
}
