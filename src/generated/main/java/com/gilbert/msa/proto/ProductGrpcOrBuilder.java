// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

package com.gilbert.msa.proto;

public interface ProductGrpcOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.gilbert.msa.ProductGrpc)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 productId = 1;</code>
   * @return The productId.
   */
  long getProductId();

  /**
   * <code>string productName = 2;</code>
   * @return The productName.
   */
  java.lang.String getProductName();
  /**
   * <code>string productName = 2;</code>
   * @return The bytes for productName.
   */
  com.google.protobuf.ByteString
      getProductNameBytes();

  /**
   * <code>int32 price = 3;</code>
   * @return The price.
   */
  int getPrice();

  /**
   * <code>int32 quantity = 4;</code>
   * @return The quantity.
   */
  int getQuantity();
}
