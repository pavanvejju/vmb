package com.vmb.enterprise.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
	
	private Long id;
	private String startDate;
	private String endDate;
	private String totalCreditAmount;
	private String currentOutstanding;
	private String rateOfInterest;
	private Integer totalInstallments;
	private Integer pendingInstallments;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	private CustomerRequestDto customerRequestDto;
}
