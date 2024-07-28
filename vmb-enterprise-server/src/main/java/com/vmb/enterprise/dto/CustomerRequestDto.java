package com.vmb.enterprise.dto;

public record CustomerRequestDto(
	
	long id,
	String firstName,
	String middleName,
	String lastName,
	String customerName,
	String emailId,
	String phoneNumber,
	String village,
	String mandal,
	String pincode,
	String address,
	String aadhaarCardNumber,
	String status,
	String type,
	String createdBy,
	String createdDate,
	String modifiedBy,
	String modifiedDate,
	String totalCreditAmount){

	public CustomerRequestDto(String customerName) {
		this(0, "", "", "", customerName, "", "", "", "", "", "", "", "", "", "", "", "", "", ""); // Default age to 0
	}
}