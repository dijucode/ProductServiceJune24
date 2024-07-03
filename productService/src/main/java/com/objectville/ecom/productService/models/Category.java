package com.objectville.ecom.productService.models;

import com.mysql.cj.conf.PropertyDefinitions;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@Entity

public class Category extends BaseModel {

    private String description;
    private String imageUrl;



}
