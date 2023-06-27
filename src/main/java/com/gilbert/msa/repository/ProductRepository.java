package com.gilbert.msa.repository;

import com.gilbert.msa.domain.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductIdIn(List<Long> productIds);
}