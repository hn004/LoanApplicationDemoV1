package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.LoanEntity;

@Repository
public interface LoanRepo extends JpaRepository<LoanEntity, Integer>{

}
