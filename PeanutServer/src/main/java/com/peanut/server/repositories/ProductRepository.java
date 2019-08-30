package com.peanut.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peanut.server.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
    void delete(Product deleted);
}
