package com.productService.representinginheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
@DiscriminatorValue("TA")
public class TA extends User {
    private int numberOfSessions;
    private double averageRating;

}
