package com.vmb.enterprise.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String addressLine1;
	private String addressLine2;
	private String zipcode;
	
	@ManyToMany
	@JoinTable(name="users_address", 
	joinColumns = @JoinColumn(name="user_id"), 
	inverseJoinColumns=@JoinColumn(name="address_id"))
	private Set<User> users	=	new HashSet<>();
}
