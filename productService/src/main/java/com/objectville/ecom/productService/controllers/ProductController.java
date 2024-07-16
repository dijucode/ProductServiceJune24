package com.objectville.ecom.productService.controllers;

import com.objectville.ecom.productService.commons.AuthCommons;
import com.objectville.ecom.productService.dtos.UserDto;
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
    private final AuthCommons authCommons;
    private  ProductService productService;
    private  ProductRepository productRepository;

    ProductController(@Qualifier("selfProductService") ProductService productService, ProductRepository productRepository, AuthCommons authCommons) {

        this.productService = productService;
        this.productRepository = productRepository;
        this.authCommons = authCommons;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id,
                                                  @RequestHeader("auth") String token) throws Exception {




//        call User Service to validate token
//
//        UserDto userDto = authCommons.validateToken(token);
//        if (userDto == null) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }



//        Role Bases Access Control
//        for (Roles role : userDto.getRoles()) {
//            if (role.getName().equals("ADMIN")) {
//                Product product = productService.getProductById(id);
//                return new ResponseEntity<>(product, HttpStatus.OK);
//            }
//        }



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
