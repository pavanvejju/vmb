package com.vmb.enterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmb.enterprise.dto.PaymentRequestDto;
import com.vmb.enterprise.service.IPaymentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;
	
	@GetMapping("/")
	public List<PaymentRequestDto> getAllPayments() {
		return paymentService.fetchAllPayments();
	}
}