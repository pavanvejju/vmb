package com.vmb.enterprise.service;

import java.util.List;

import com.vmb.enterprise.dto.PaymentRequestDto;
import com.vmb.enterprise.model.Payment;

public interface IPaymentService {

	List<PaymentRequestDto> fetchAllPayments();

	void savePayment(Payment payment);

}
