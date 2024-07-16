package com.objectville.ecom.productService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;
    private int qty;

}


