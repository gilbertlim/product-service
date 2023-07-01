package com.gilbert.msa.service.grpc.mapper;

import com.gilbert.msa.domain.dto.ProductDto;
import com.gilbert.msa.proto.ProductGrpc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrpcMapper {

    ProductGrpc toProductGrpc(ProductDto productDto);
}