package com.prices.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PriceResponse {

    private Integer brandId;

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss", timezone="Europe/Madrid")
    private Date startDate;

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss", timezone="Europe/Madrid")
    private Date endDate;

    private Integer priceList;

    private Long productId;

    private Double price;
}
