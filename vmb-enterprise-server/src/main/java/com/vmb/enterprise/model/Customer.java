package com.vmb.enterprise.model;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer", catalog = "vmb_enterprise")
public record Customer(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id,
	 String firstName,
	 String lastName,
	 String middleName,
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
	 Timestamp createdDate,
	 String modifiedBy,
	 Timestamp modifiedDate) implements Serializable
{
	public Customer customerWithStatus(String newStatus){
		return new Customer(
				id,
				firstName,
				lastName,
				middleName,
				customerName,
				emailId,
				phoneNumber,
				village,
				mandal,
				pincode,
				address,
				aadhaarCardNumber,
				newStatus,
				type,
				createdBy,
				createdDate,
				modifiedBy,
				modifiedDate);
	}

	public Customer customerWithFLME(String newFirstName,String newLastName, String newMiddleName, String newEmail,
									   String newPhoneNumber, String newVillage, String newMandal, String newPinCode, String newAddress){
		return new Customer(
				id,
				newFirstName,
				newLastName,
				newMiddleName,
				customerName,
				newEmail,
				newPhoneNumber,
				newVillage,
				newMandal,
				newPinCode,
				newAddress,
				aadhaarCardNumber,
				status,
				type,
				createdBy,
				createdDate,
				modifiedBy,
				modifiedDate);
	}
}