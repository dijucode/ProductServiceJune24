package com.productService.controllers;

import com.productService.exceptions.ProductNotFoundException;
import com.productService.models.Product;
import com.productService.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void validGetProductById() throws Exception {
        Product product = new Product();
        when(productService.getProductById(1L))
                .thenReturn(product);


        Product actualProduct = productController.getProductById(1L, "Product with id 1 not found").getBody();
        assertEquals(product, actualProduct);




    }
    @Test
    void testAllProducts() {

        List<Product> expectedProducts = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("iPhone 12");

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("iPhone 12 Pro");

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("iPhone 12 Pro Max");

        when(productService.getAllProducts())
                .thenReturn(expectedProducts);


        assertIterableEquals(expectedProducts, productController.getAllProducts());
    }
    @Test
    void invalidGetProductById() throws Exception {
        when(productService.getProductById(1L))
                .thenThrow(new ProductNotFoundException(1L, "Product with id 1 not found"));

        assertThrows(ProductNotFoundException.class, () -> productController.getProductById(1L, "Product with id 1 not found"));
    }
}