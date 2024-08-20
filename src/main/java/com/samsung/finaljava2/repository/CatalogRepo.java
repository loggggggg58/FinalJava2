package com.samsung.finaljava2.repository;

import com.samsung.finaljava2.repository.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepo extends JpaRepository<Catalog, Long> {
}
