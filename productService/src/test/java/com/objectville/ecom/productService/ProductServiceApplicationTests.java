package com.objectville.ecom.productService;

import com.objectville.ecom.productService.models.Category;
import com.objectville.ecom.productService.models.Product;
import com.objectville.ecom.productService.projections.ProductWithTitleAndDescription;
import com.objectville.ecom.productService.repositories.CategoryRepository;
import com.objectville.ecom.productService.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private ProductRepository productRepository;

	@Test
	@Transactional
	public void testTC(){
//		Optional<Category> optionalCategory = categoryRepository.findById(1L);
//		Category category = optionalCategory.get();
//
//		System.out.println("Fetching category with id 1: " + category.getDescription());
////		List<Product> products = category.getProducts();
//
//
//		ProductWithTitleAndDescription product = productRepository.someRandomQuery(1L);
//		System.out.println(product.getTitle());
//		System.out.println(product.getDescription());
//
//		ProductWithTitleAndDescription otherProduct = productRepository.someOtherRandomQuery(1L);
//		System.out.println(otherProduct.getTitle());
//		System.out.println(otherProduct.getDescription());
//		System.out.println("DEBUG");

	}

}
