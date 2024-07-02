package com.objectville.ecom.productService.controllers;

import com.objectville.ecom.productService.exceptions.ProductNotFoundException;
import com.objectville.ecom.productService.models.Product;
import com.objectville.ecom.productService.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    ProductController( ProductService productService) {

        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception {
        Product product = productService.getProductByID(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable("id") Long id) {
        return productService.replaceProduct(newProduct, id);
    }

    //createUpdate
    //delete
    //updateProduct

}
