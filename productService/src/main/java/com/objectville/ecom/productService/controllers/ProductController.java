package com.objectville.ecom.productService.controllers;

import com.objectville.ecom.productService.models.Product;
import com.objectville.ecom.productService.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    ProductController( ProductService productService) {

        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        return productService.getProductByID(id);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return null;
    }

    //createUpdate
    //delete
    //updateProduct

}
