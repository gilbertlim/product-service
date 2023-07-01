package com.gilbert.msa.service.grpc;

import com.gilbert.msa.domain.dto.ProductDto;
import com.gilbert.msa.proto.ProductGrpc;
import com.gilbert.msa.proto.ProductRequestGrpc;
import com.gilbert.msa.proto.ProductResponseGrpc;
import com.gilbert.msa.proto.ProductServiceGrpc;
import com.gilbert.msa.service.ProductService;
import com.gilbert.msa.service.grpc.mapper.GrpcMapper;
import io.grpc.stub.StreamObserver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@RequiredArgsConstructor
@GrpcService
public class ProductGrpcService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductService productService;

    private final GrpcMapper grpcMapper;

    @Override
    public void getProducts(ProductRequestGrpc request, StreamObserver<ProductResponseGrpc> responseObserver) {
        String logPrefix = "ProductGrpcService#getProducts";
        log.info(logPrefix + " productIds - {}", request.getProductIdsList());

        List<ProductDto> productDtos = productService.getProducts(request.getProductIdsList());
        List<ProductGrpc> productGrpcs = productDtos.stream()
            .map(grpcMapper::toProductGrpc)
            .toList();

        ProductResponseGrpc productResponseGrpc = ProductResponseGrpc.newBuilder()
            .addAllProductGrpc(productGrpcs)
            .build();

        responseObserver.onNext(productResponseGrpc);
        responseObserver.onCompleted();

        log.info(logPrefix + " - completed");
    }
}
