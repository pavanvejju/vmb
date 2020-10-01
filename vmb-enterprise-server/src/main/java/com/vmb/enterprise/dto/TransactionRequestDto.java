package com.vmb.enterprise.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class TransactionRequestDto {
	
	private String dateStr;
	private String type; // Credit / Debit
	private String description;
	private BigDecimal amount;
	private Long customerId;
	private String customerName;
	private String createdBy;
	private Timestamp createdDate;
}
