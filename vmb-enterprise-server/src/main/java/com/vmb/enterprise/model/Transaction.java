package com.vmb.enterprise.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction", catalog = "vmb_enterprise")
public record Transaction (

	/**
	 * @author pavanvejju 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id,
	 Date date,
	 String type,  // Credit / Debit
	 String description,
	 BigDecimal amount,
	 String createdBy,
	 Timestamp createdDate,
	@ManyToOne
	@JoinColumn(name="customerId")
	 Customer customer,
	@ManyToOne
	@JoinColumn(name="paymentId")
	 Payment payment
	) implements Serializable {
}
