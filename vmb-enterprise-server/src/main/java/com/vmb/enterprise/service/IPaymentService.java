package com.vmb.enterprise.service;

import com.vmb.enterprise.dto.PaymentRequestDto;
import com.vmb.enterprise.model.Payment;

import java.util.List;

public interface IPaymentService {
	List<PaymentRequestDto> fetchAllPayments();
	void savePayment(Payment payment);
}
