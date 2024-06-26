package com.objectville.ecom.productService.services;

import com.objectville.ecom.productService.FakeStoreProductDto.FakeStoreProductDto;
import com.objectville.ecom.productService.models.Category;
import com.objectville.ecom.productService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService {

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
    public Product getProductByID(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if (fakeStoreProductDto != null) {
            return convertFakeStoreDtoToProduct(fakeStoreProductDto);
        } else {
            return null; // or throw an exception, depending on your use case
        }
    }

    @Override
    public List<Product> getAllProducts() {

        return null; // or throw an exception, depending on your use case

    }
}
