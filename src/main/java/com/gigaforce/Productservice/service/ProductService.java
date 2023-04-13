package com.gigaforce.Productservice.service;

import com.gigaforce.Productservice.model.ProductRequest;
import com.gigaforce.Productservice.model.ProductResponse;

public interface ProductService {
    Long addProduct (ProductRequest productRequest);

    ProductResponse getProductById (Long productId);

    void reduceQuantity (Long productId, Long quantity);
}
