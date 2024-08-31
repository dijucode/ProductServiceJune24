package com.productService.controllers;

import com.productService.commons.AuthCommons;
import com.productService.models.Product;
import com.productService.repositories.ProductRepository;
import com.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final AuthCommons authCommons;
    private  ProductService productService;
    private ProductRepository productRepository;

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
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
        return productService.getAllProducts(pageNumber, pageSize);
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
