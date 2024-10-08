package com.samsung.finaljava2.repository;

import com.samsung.finaljava2.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "select * from products where catalog_id = ?1", nativeQuery = true)
    public List<Product> findAllByCatalogId(Long catalogId);
}
