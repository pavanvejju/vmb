package com.vmb.enterprise.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
	
	private Long id;
	private String startDate;
	private String endDate;
	private String totalCreditAmount;
	private String currentOutstanding;
	private String rateOfInterest;
	private Integer totalInstallments;
	private Integer pendingInstallments;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	private CustomerRequestDto customerRequestDto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTotalCreditAmount() {
		return totalCreditAmount;
	}
	public void setTotalCreditAmount(String totalCreditAmount) {
		this.totalCreditAmount = totalCreditAmount;
	}
	public String getCurrentOutstanding() {
		return currentOutstanding;
	}
	public void setCurrentOutstanding(String currentOutstanding) {
		this.currentOutstanding = currentOutstanding;
	}
	public String getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Integer getTotalInstallments() {
		return totalInstallments;
	}
	public void setTotalInstallments(Integer totalInstallments) {
		this.totalInstallments = totalInstallments;
	}
	public Integer getPendingInstallments() {
		return pendingInstallments;
	}
	public void setPendingInstallments(Integer pendingInstallments) {
		this.pendingInstallments = pendingInstallments;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public CustomerRequestDto getCustomerRequestDto() {
		return customerRequestDto;
	}
	public void setCustomerRequestDto(CustomerRequestDto customerRequestDto) {
		this.customerRequestDto = customerRequestDto;
	}
	
	
}
