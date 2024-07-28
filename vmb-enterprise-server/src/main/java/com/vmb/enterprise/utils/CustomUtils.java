package com.vmb.enterprise.utils;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.dto.TransactionRequestDto;
import com.vmb.enterprise.model.Customer;
import com.vmb.enterprise.model.Payment;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CustomUtils {

	
	
	/**
	 * @param customerRequestDto
	 * @param customer
	 * @return
	 */
	public static Payment constructDtoToPaymentByCustomer(CustomerRequestDto customerRequestDto, Customer customer) {

		Date currentDate = new Date();
		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusDays(100);
		Date datePlusHundred = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		Payment payment	=	new Payment(0L,
				currentDate,
				datePlusHundred,
				new BigDecimal(customerRequestDto.totalCreditAmount()),
				new BigDecimal(customerRequestDto.totalCreditAmount()),
				new BigDecimal(3.00),
				100,
				100,
				customerRequestDto.createdBy(),
				new Timestamp(System.currentTimeMillis()),
				customerRequestDto.createdBy(),
				new Timestamp(System.currentTimeMillis()),
				customer
				);
		return payment;
	}
	
	/**
	 * @param transactionRequestDto, payment
	 * @return
	 */
	public static Payment constructDtoToPaymentByTransaction(TransactionRequestDto transactionRequestDto, Payment payment) {
			/*payment.setPendingInstallments(payment.getPendingInstallments()-1);
			payment.setCurrentOutstanding(payment.getCurrentOutstanding().subtract(transactionRequestDto.getAmount()));
			payment.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			payment.setModifiedBy(transactionRequestDto.getCreatedBy());*/
		return payment;
	}
	

	public static String prepareVideoFileName() {
		Date date = new Date();
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy_MM_dd");
		SimpleDateFormat HHmm = new SimpleDateFormat("HH_mm");
		String dateyyyyMMdd= yyyyMMdd.format(date);
		String dateHHmm= HHmm.format(date);
		//System.out.println(dateyyyyMMdd);
		//System.out.println(dateHHmm);
		
		return dateyyyyMMdd+"/video_"+dateHHmm+".mp4";
	}
	
}
