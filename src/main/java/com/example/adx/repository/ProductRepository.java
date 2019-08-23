package com.example.adx.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adx.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
