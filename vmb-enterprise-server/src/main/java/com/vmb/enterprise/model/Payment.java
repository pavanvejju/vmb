package com.vmb.enterprise.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "payment", catalog = "vmb_enterprise")
public record Payment (
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long id,
	 Date startDate,
	 Date endDate,
	 BigDecimal totalCreditAmount,
	 BigDecimal currentOutstanding,
	 BigDecimal rateOfInterest,
	 Integer totalInstallments,
	 Integer pendingInstallments,
	 String createdBy,
	 Timestamp createdDate,
	 String modifiedBy,
	 Timestamp modifiedDate,
	@ManyToOne
	@JoinColumn(name="customerId")
	 Customer customer) implements Serializable
{}