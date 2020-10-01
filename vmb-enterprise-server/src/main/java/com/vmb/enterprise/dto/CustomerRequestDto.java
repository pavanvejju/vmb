package com.vmb.enterprise.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class CustomerRequestDto {
	
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String customerName;
	private String emailId;
	private String phoneNumber;
	private String village;
	private String mandal;
	private String pincode;
	private String address;
	private String aadhaarCardNumber;
	private String status;
	private String type;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	private BigDecimal totalCreditAmount;
	
}
