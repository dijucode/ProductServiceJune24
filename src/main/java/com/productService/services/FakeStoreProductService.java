package com.productService.services;

import com.productService.dtos.FakeStoreProductDto;
import com.productService.exceptions.ProductNotFoundException;
import com.productService.models.Category;
import com.productService.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    // to test runtime exception at service layer



    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImage());


        Category category = new Category();
        category.setId(dto.getId());

        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(Long id) throws Exception {
        // Simulating an exception to demonstrate exception handling
        if (id < 0) {
            throw new Exception("Invalid product ID");
        }

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if (fakeStoreProductDto != null) {
            return convertFakeStoreDtoToProduct(fakeStoreProductDto);
        } else {
            throw new ProductNotFoundException(id, "Product with id "+ id +" not found");
        }
    }


    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
//        if (fakeStoreProductDtos != null) {
//            List<Product> products = new ArrayList<>();
//            for (FakeStoreProductDto dto : fakeStoreProductDtos) {
//                products.add(convertFakeStoreDtoToProduct(dto));
//            }
//            return products;
//        }
        return null;

         // or throw an exception, depending on your use case

    }
    public Product replaceProduct(Product newProduct, Long id) {
        restTemplate.put("https://fakestoreapi.com/products/" + id, newProduct, Product.class);
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
