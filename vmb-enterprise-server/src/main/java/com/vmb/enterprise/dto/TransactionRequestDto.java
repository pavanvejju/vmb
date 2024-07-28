package com.vmb.enterprise.dto;

import java.math.BigDecimal;
public record TransactionRequestDto (
	 String dateStr,
	 String type, // Credit / Debit
	 String description,
	 BigDecimal amount,
	 Long customerId,
	 String customerName,
	 String createdBy,
	 String createdDate){
}