package com.objectville.ecom.productService.models;

import com.mysql.cj.conf.PropertyDefinitions;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;


@Getter
@Setter
@Entity

public class Category extends BaseModel {

    private String description;
    private String imageUrl;
//    @OneToMany(mappedBy = "category")
//    private List<Product> products;



}
