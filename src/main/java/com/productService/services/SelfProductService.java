package com.productService.services;

import com.productService.exceptions.ProductNotFoundException;
import com.productService.models.Category;
import com.productService.models.Product;
import com.productService.repositories.CategoryRepository;
import com.productService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public Product getProductById(Long id) throws Exception {
//        Fetch product from database using id
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        else{throw new ProductNotFoundException(id, "Product not found");}
        
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by("price").ascending()));
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
//            Category savedCategory = categoryRepository.save(category);
//            newProduct.setCategory(savedCategory);
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
