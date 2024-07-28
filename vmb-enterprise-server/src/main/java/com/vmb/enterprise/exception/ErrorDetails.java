package com.vmb.enterprise.exception;

import java.util.Date;
public record ErrorDetails (
	Date timestamp,
	String details,
	Integer errorCode,
	String errorDescription)
{}
