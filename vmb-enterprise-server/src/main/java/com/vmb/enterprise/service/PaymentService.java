package com.vmb.enterprise.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.dto.PaymentRequestDto;
import com.vmb.enterprise.model.Payment;
import com.vmb.enterprise.repository.PaymentRepository;

@Service
public class PaymentService  implements IPaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Transactional
	@Override
	public List<PaymentRequestDto> fetchAllPayments() {
		
		SimpleDateFormat sdfr = new SimpleDateFormat("dd-MM-yyyy");
		
		List<PaymentRequestDto>	paymentRequestDtoList	=	new ArrayList<PaymentRequestDto>();
		List<Payment> paymentList	=	paymentRepository.findAll();
		for(Payment payment: paymentList) {
			CustomerRequestDto customerRequestDto	=	new CustomerRequestDto(payment.customer().customerName());
			PaymentRequestDto paymentRequestDto	=	new PaymentRequestDto(
					payment.id(),
					sdfr.format(payment.startDate()),
					sdfr.format(payment.endDate()),
					payment.totalCreditAmount().toString(),
					payment.currentOutstanding().toString(),
					payment.rateOfInterest().toString(),
					payment.totalInstallments(),
					payment.pendingInstallments(),
					payment.createdBy(),
					sdfr.format(payment.createdDate()),
					payment.modifiedBy(),
					sdfr.format(payment.modifiedDate()),
					customerRequestDto
			);
			paymentRequestDtoList.add(paymentRequestDto);
		}
		return	paymentRequestDtoList; 	
	}
	
	@Transactional
	@Override
	public void savePayment(Payment payment) {
		paymentRepository.saveAndFlush(payment);
	}
}
