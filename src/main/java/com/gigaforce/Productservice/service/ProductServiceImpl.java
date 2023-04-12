package com.gigaforce.Productservice.service;

import com.gigaforce.Productservice.entity.Product;
import com.gigaforce.Productservice.exception.ProductServiceCustomException;
import com.gigaforce.Productservice.model.ProductRequest;
import com.gigaforce.Productservice.model.ProductResponse;
import com.gigaforce.Productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Long addProduct (ProductRequest productRequest) {
        log.info("Adding product..");
        Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("Product created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById (Long productId) {
        log.info("get product by id : {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product with given id does not exist.", "PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
