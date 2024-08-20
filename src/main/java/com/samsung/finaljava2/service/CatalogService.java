package com.samsung.finaljava2.service;

import com.samsung.finaljava2.repository.CatalogRepo;
import com.samsung.finaljava2.repository.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService implements ICatalogService {
    @Autowired
    CatalogRepo catalogRepo;

    @Override
    public List<Catalog> getCatalogs() {
        return catalogRepo.findAll();
    }
}
