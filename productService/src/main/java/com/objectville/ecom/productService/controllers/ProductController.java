package com.objectville.ecom.productService.controllers;

import com.objectville.ecom.productService.exceptions.ProductNotFoundException;
import com.objectville.ecom.productService.models.Product;
import com.objectville.ecom.productService.repositories.ProductRepository;
import com.objectville.ecom.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private  ProductService productService;
    private final ProductRepository productRepository;

    ProductController(@Qualifier("selfProductService") ProductService productService, ProductRepository productRepository) {

        this.productService = productService;
        this.productRepository = productRepository;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception {
        Product product = productService.getProductById(id);
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



    @PostMapping
    public Product createProduct(@RequestBody Product newProduct) {
        // Using the productService to handle creation logic
        return productService.createProduct(newProduct);
    }

}
