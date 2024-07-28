package com.vmb.enterprise.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public record Department (
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id,
	String addressLine1,
	String addressLine2,
	String zipcode,
	@ManyToMany
	@JoinTable(name="users_address", 
	joinColumns = @JoinColumn(name="user_id"), 
	inverseJoinColumns=@JoinColumn(name="address_id"))
	Set<User> users)
	{}
