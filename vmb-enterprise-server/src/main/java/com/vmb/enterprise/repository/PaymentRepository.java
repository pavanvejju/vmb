package com.vmb.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmb.enterprise.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	public Payment findByCustomerId(Long customerId);
	
}
