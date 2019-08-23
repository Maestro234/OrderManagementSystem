package com.example.adx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adx.entity.AccountEntity;


public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

}
