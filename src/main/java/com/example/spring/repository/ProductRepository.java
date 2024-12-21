package com.example.spring.repository;

import com.example.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContains(String name);
    List<Product> findAllByNameOrPrice(String name, Double price);
    List<Product> findAllByNameAndPrice(String name, Double price);
    @Query("SELECT p from Product p"+
            " WHERE (:name is NULL or p.name LIKE %:name%)"+
            " AND (:minPrice is NULL or p.price >= :minPrice)"+
            " AND (:maxPrice is NULL or p.price <= :maxPrice)"
    )
    List<Product> filter(@Param("name") String name,@Param("minPrice") Double minPrice,
                         @Param("maxPrice") Double maxPrice);


}
