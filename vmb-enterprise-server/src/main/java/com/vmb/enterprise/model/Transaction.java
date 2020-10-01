package com.vmb.enterprise.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "transaction", catalog = "vmb_enterprise")
@Data
public class Transaction implements Serializable{

	/**
	 * @author pavanvejju 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private String type; // Credit / Debit
	private String description;
	private BigDecimal amount;
	private String createdBy;
	private Timestamp createdDate;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="paymentId")
	private Payment payment;
}
