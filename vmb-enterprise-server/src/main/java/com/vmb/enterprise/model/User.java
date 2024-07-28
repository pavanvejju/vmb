package com.vmb.enterprise.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public record User(

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id,
	String userName,
	String emailId,
	@OneToMany(mappedBy = "user")
	List<Address> address,
	@ManyToMany(mappedBy = "users")
	Set<Department> departments
){}
