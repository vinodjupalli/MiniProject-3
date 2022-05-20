package com.vinod.jrtp.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {
	
	private String planName;
	private String planStatus;
	private Long caseNum;
	private String holderName;
	private Long holderSsn;
	private Double benefitAmt;
	private String denailReason;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	
	
}
