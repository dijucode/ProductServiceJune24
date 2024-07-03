package com.objectville.ecom.productService.services;

import com.objectville.ecom.productService.exceptions.ProductNotFoundException;
import com.objectville.ecom.productService.models.Category;
import com.objectville.ecom.productService.models.Product;
import com.objectville.ecom.productService.repositories.CategoryRepository;
import com.objectville.ecom.productService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public Product getProductByID(Long id) throws Exception {
//        Fetch product from database using id
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        else{throw new ProductNotFoundException(id, "Product not found");}
        
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

//        before saving the product object in db, save the category object.
        Category category = newProduct.getCategory();
        if (category.getId()== null){
//            we need to save the category.
            Category savedCategory = categoryRepository.save(category);
            newProduct.setCategory(savedCategory);
        }
//        else{//we sd check if the category exists in the db}
        Product savedProduct = productRepository.save(newProduct);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
