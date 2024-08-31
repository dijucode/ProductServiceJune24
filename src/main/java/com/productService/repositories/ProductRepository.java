package com.productService.repositories;

import com.productService.models.Product;
import com.productService.projections.ProductWithTitleAndDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
    List<Product> findByTitle(String title);
    List<Product> findByTitleContains(String string);


    @Override
    Page<Product> findAll(Pageable pageable);

    @Override
    void delete(Product entity);

    @Override
    Product save(Product entity);

    @Query("select p.title as title, p.description as description from Product p where p.id = :id")
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);

//    SQL Query (Native Query)
    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDescription someOtherRandomQuery(@Param("id") Long id);
}


