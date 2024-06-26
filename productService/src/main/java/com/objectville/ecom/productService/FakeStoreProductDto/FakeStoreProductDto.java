package com.objectville.ecom.productService.FakeStoreProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image; // Use "image" to match the JSON key
    private String category; // Use "category" as a string

    // Getters and Setters
}
