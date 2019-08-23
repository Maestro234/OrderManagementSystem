package com.example.adx.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.adx.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
