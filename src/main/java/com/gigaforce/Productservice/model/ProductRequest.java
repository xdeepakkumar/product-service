package com.gigaforce.Productservice.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Long quantity;

    private Long price;
}
