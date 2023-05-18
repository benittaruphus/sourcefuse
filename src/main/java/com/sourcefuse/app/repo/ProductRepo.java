package com.sourcefuse.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcefuse.app.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{

}
