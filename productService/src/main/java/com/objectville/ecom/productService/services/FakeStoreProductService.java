package com.objectville.ecom.productService.services;

import com.objectville.ecom.productService.dtos.FakeStoreProductDto;
import com.objectville.ecom.productService.exceptions.ProductNotFoundException;
import com.objectville.ecom.productService.models.Category;
import com.objectville.ecom.productService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
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
        category.setDescription(dto.getDescription());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductByID(Long id) throws Exception {
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
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        if (fakeStoreProductDtos != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDto dto : fakeStoreProductDtos) {
                products.add(convertFakeStoreDtoToProduct(dto));
            }
            return products;
        }
        return null;

         // or throw an exception, depending on your use case

    }
    public Product replaceProduct(Product newProduct, Long id) {
        restTemplate.put("https://fakestoreapi.com/products/" + id, newProduct, Product.class);
        return null;
    }
}
