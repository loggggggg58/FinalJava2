package com.samsung.finaljava2.service;

import com.samsung.finaljava2.repository.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getProducts();
    public List<Product> getProductsByCatalogId(Long catalogId);
}
