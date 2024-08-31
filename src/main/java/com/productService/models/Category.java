package com.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String category;

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
