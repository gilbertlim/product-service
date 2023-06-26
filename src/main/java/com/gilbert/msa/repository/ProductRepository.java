package com.gilbert.msa.repository;

import com.gilbert.msa.domain.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tbl_product as p WHERE p.product_id IN (:productIds)")
    List<Product> findByProductIds(@Param("productIds") List<Integer> productIds);

}