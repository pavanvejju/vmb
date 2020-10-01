package com.vmb.enterprise.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.dto.TransactionRequestDto;
import com.vmb.enterprise.model.Customer;
import com.vmb.enterprise.model.Payment;

public class CustomUtils {

	
	
	/**
	 * @param customerRequestDto
	 * @param customer
	 * @return
	 */
	public static Payment constructDtoToPaymentByCustomer(CustomerRequestDto customerRequestDto, Customer customer) {
		Payment payment	=	new Payment();
			payment.setCustomer(customer);
		    Date currentDate = new Date();
		    LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		    localDateTime = localDateTime.plusDays(100);
		    Date datePlusHundred = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		    payment.setStartDate(currentDate);
			payment.setEndDate(datePlusHundred);
			payment.setTotalCreditAmount(customerRequestDto.getTotalCreditAmount());
			payment.setCurrentOutstanding(customerRequestDto.getTotalCreditAmount());
			payment.setRateOfInterest(new BigDecimal(3.00));
			payment.setPendingInstallments(100);
			payment.setTotalInstallments(100);
			payment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			payment.setCreatedBy(customerRequestDto.getCreatedBy());
			payment.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			payment.setModifiedBy(customerRequestDto.getCreatedBy());
		return payment;
	}
	
	/**
	 * @param transactionRequestDto
	 * @param customer1
	 * @return
	 */
	public static Payment constructDtoToPaymentByTransaction(TransactionRequestDto transactionRequestDto, Payment payment) {
		   
			payment.setPendingInstallments(payment.getPendingInstallments()-1);
			payment.setCurrentOutstanding(payment.getCurrentOutstanding().subtract(transactionRequestDto.getAmount()));
			payment.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			payment.setModifiedBy(transactionRequestDto.getCreatedBy());
		return payment;
	}
}
