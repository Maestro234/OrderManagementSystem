package com.example.adx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adx.entity.ServiceImplEntity;

public interface ServiceRepository extends JpaRepository<ServiceImplEntity, Integer> {

}
