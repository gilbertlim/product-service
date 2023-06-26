package com.gilbert.msa.service;

import com.gilbert.msa.domain.dto.ProductDto;
import com.gilbert.msa.domain.entity.Product;
import com.gilbert.msa.domain.mapper.ProductMapper;
import com.gilbert.msa.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Transactional
    public void createOrder(ProductDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    public ProductDto getProduct(Long id) {

        Product entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find id: " + id));
        return mapper.toDto(entity);
    }

    public List<ProductDto> getProducts() {
        return repository.findAll()
            .stream()
            .map(mapper::toDto)
            .toList();
    }

    @Transactional
    public void deleteProduct(ProductDto dto) {
        repository.delete(mapper.toEntity(dto));
    }

    public List<ProductDto> getProductsFromIds(List<Integer> productIds) {
        return repository.findByProductIds(productIds)
            .stream()
            .map(mapper::toDto)
            .toList();
    }
}