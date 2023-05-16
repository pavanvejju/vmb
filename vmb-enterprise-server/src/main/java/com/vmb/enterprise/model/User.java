package com.vmb.enterprise.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String emailId;
	
	@OneToMany(mappedBy = "user")
	private List<Address> address=new ArrayList<>(); 
	
	@ManyToMany(mappedBy = "users")
	private Set<Department> departments	=	new HashSet<>();
}
