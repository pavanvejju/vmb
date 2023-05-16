package com.vmb.enterprise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String addressLine1;
	private String addressLine2;
	private String zipcode;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
