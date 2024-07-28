package com.vmb.enterprise.dto;

public record PaymentRequestDto (
	 Long id,
	 String startDate,
	 String endDate,
	 String totalCreditAmount,
	 String currentOutstanding,
	 String rateOfInterest,
	 Integer totalInstallments,
	 Integer pendingInstallments,
	 String createdBy,
	 String createdDate,
	 String modifiedBy,
	 String modifiedDate,
	 CustomerRequestDto customerRequestDto)
{}
