package com.vmb.enterprise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public record Address(

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id,
	String addressLine1,
	String addressLine2,
	String zipcode,
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user)
{}
