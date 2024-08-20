package com.samsung.finaljava2.service;

import com.samsung.finaljava2.repository.ProductRepo;
import com.samsung.finaljava2.repository.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByCatalogId(Long catalogId) {
        return productRepo.findAllByCatalogId(catalogId);
    }
}
