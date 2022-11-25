package com.prices.repository;

import com.prices.dto.PriceId;
import com.prices.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, PriceId> {

    @Query("SELECT p FROM Price p " +
            "WHERE p.startDate <= :appDate " +
            "AND p.endDate >= :appDate " +
            "AND p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "ORDER BY p.priority DESC")
    List<Price> findPrice(Date appDate, Long productId, Integer brandId);

}
