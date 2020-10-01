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
			PaymentRequestDto paymentRequestDto	=	new PaymentRequestDto();
			paymentRequestDto.setCreatedBy(payment.getCreatedBy());
			paymentRequestDto.setModifiedBy(payment.getModifiedBy());
			paymentRequestDto.setCreatedDate(sdfr.format(payment.getCreatedDate()));
			paymentRequestDto.setModifiedDate(sdfr.format(payment.getModifiedDate()));
			paymentRequestDto.setStartDate(sdfr.format(payment.getStartDate()));
			paymentRequestDto.setEndDate(sdfr.format(payment.getEndDate()));
			paymentRequestDto.setTotalCreditAmount(payment.getTotalCreditAmount().toString());
			paymentRequestDto.setCurrentOutstanding(payment.getCurrentOutstanding().toString());
			paymentRequestDto.setTotalInstallments(payment.getTotalInstallments());
			paymentRequestDto.setPendingInstallments(payment.getPendingInstallments());
			paymentRequestDto.setId(payment.getId());
			paymentRequestDto.setRateOfInterest(payment.getRateOfInterest().toString());
			CustomerRequestDto customerRequestDto	=	new CustomerRequestDto();
			customerRequestDto.setCustomerName(payment.getCustomer().getCustomerName());
			paymentRequestDto.setCustomerRequestDto(customerRequestDto);
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
