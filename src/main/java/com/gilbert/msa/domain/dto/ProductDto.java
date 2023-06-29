package com.gilbert.msa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Integer productId;
    private String productName;
    private Integer price;
    private Integer quantity;
}