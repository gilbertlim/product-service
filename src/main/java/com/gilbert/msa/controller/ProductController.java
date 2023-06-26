package com.gilbert.msa.controller;

import com.gilbert.msa.domain.dto.ProductDto;
import com.gilbert.msa.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductService service;

    @PostMapping
    public void createProduct(@RequestBody ProductDto requestDto) {
        log.info("createProduct");
        service.createOrder(requestDto);
    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        log.info("getProduct");
        return service.getProduct(productId);
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        log.info("getProducts");
        return service.getProducts();
    }

    @PostMapping("/ids")
    public List<ProductDto> getProductsFromIds(@RequestBody List<Integer> productIds) {
        log.info("getProductsFromIds");
        return service.getProductsFromIds(productIds);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody ProductDto requestDto) {
        log.info("deleteProduct");
        service.deleteProduct(requestDto);
    }
}
