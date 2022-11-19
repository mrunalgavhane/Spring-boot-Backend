package com.codewitharjun.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewitharjun.fullstackbackend.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Integer>{

}
