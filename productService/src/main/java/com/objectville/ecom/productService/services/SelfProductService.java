package com.objectville.ecom.productService.services;

import com.objectville.ecom.productService.models.Product;
import com.objectville.ecom.productService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductByID(Long id) throws Exception {
//        Fetch product from database using id
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(Product newProduct, Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product newProduct) {
        return null;
    }

    @Override
    public Product createProduct(Product newProduct) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
