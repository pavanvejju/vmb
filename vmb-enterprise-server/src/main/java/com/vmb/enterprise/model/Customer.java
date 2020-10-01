package com.vmb.enterprise.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customer", catalog = "vmb_enterprise")
@Data
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
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
	
	
}