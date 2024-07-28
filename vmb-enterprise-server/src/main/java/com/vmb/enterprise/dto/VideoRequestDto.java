package com.vmb.enterprise.dto;
public record VideoRequestDto(
	String url,
	String topic,
	int minitues,
	String quality,
	String tableName)
{}
