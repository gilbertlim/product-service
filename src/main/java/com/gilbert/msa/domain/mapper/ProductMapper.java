package com.gilbert.msa.domain.mapper;

import com.gilbert.msa.domain.dto.ProductDto;
import com.gilbert.msa.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDto productDto);

    @Mapping(source = "product_id", target = "productId")
    @Mapping(source = "product_name", target = "productName")
    ProductDto toDto(Product product);
}