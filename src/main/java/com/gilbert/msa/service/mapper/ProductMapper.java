package com.gilbert.msa.service.mapper;

import com.gilbert.msa.domain.dto.ProductDto;
import com.gilbert.msa.domain.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);
}