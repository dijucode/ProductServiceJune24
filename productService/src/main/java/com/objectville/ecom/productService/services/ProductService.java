package com.objectville.ecom.productService.services;

import com.objectville.ecom.productService.exceptions.ProductNotFoundException;
import com.objectville.ecom.productService.models.Product;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

public interface ProductService {





    Product getProductByID(Long id) throws Exception;

    List<Product> getAllProducts();

    Product replaceProduct(Product newProduct, Long id);

}
