package com.prices.entity;

import com.prices.dto.PriceId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRICES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PriceId.class)
public class Price {

    private Integer brandId;

    private Date startDate;

    private Date endDate;

    @Id
    private Integer priceList;

    @Id
    private Long productId;

    private Integer priority;

    private Double price;

    private String curr;
}