package com.vmb.enterprise.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails {
	private Date timestamp;
	private String details;
	private Integer errorCode;
	private String errorDescription;
}
