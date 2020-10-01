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
@Table(name = "payment", catalog = "vmb_enterprise")
@Data
public class Payment  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date startDate;
	private Date endDate;
	private BigDecimal totalCreditAmount;
	private BigDecimal currentOutstanding;
	private BigDecimal rateOfInterest;
	private Integer totalInstallments;
	private Integer pendingInstallments;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
}