package com.gilbert.msa.service.grpc;

import com.gilbert.msa.domain.dto.ProductDto;
import com.gilbert.msa.proto.ProductGrpc;
import com.gilbert.msa.proto.ProductRequestGrpc;
import com.gilbert.msa.proto.ProductResponseGrpc;
import com.gilbert.msa.proto.ProductServiceGrpc;
import com.gilbert.msa.service.ProductService;
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

    @Override
    public void getProducts(ProductRequestGrpc request, StreamObserver<ProductResponseGrpc> responseObserver) {
        String prefixLog = "ProductGrpcService#getProducts";
        log.info(prefixLog + " - {}", request.getProductIdsList());

        List<ProductDto> products = productService.getProducts(request.getProductIdsList());
        List<ProductGrpc> productGrpc = products.stream()
            .map(product -> {
                return ProductGrpc.newBuilder()
                    .setProductId(product.getProductId())
                    .setProductName(product.getProductName())
                    .setPrice(product.getPrice())
                    .setQuantity(product.getQuantity())
                    .build();
            }).toList();

        ProductResponseGrpc productResponseGrpc = ProductResponseGrpc.newBuilder()
            .addAllProductGrpc(productGrpc)
            .build();

        responseObserver.onNext(productResponseGrpc);
        responseObserver.onCompleted();

        log.info(prefixLog + " - completed");
    }
}
