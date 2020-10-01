package com.vmb.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmb.enterprise.model.Customer;
import com.vmb.enterprise.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
}
