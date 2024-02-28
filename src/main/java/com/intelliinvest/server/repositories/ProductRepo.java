package com.intelliinvest.server.repositories;

import com.intelliinvest.server.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
