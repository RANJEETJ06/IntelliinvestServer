package com.intelliinvest.server.services;

import com.intelliinvest.server.payloads.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
    void DeleteProduct(Integer id);
}
