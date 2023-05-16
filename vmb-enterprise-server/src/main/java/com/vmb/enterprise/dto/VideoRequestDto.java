package com.vmb.enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoRequestDto {
	private String url;
	private String topic;
	private int minitues;
	private String quality;
	private String tableName;
}
