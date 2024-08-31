package com.productService.services;

import com.productService.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {





    Product getProductById(Long id) throws Exception;

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product replaceProduct(Product newProduct, Long id);

    Product updateProduct(Long id, Product newProduct);

    Product createProduct(Product newProduct);

    void deleteProduct(Long id);


}
