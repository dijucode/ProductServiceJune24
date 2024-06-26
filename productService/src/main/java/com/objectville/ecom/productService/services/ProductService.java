package com.objectville.ecom.productService.services;

import com.objectville.ecom.productService.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {


    Product getProductByID(Long id);

    List<Product> getAllProducts();

}
