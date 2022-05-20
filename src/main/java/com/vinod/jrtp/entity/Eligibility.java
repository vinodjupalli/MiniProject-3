package com.vinod.jrtp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ELIGIBLITY_DTLS")
@Data
public class Eligibility {
	@Id
	@GeneratedValue
	@Column(name = "ELIGIBLITY_ID")
	private Integer eligiId;
    @Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Column(name = "CASE_NUM")
	private Long caseNum;
	@Column(name = "HOLDER_NAME")
	private String holderName;
	@Column(name = "HOLDER_SSN")
	private Long holderSsn;
	@Column(name = "BENEFIT_AMT")
	private Double benefitAmt;
	@Column(name = "DENIAL_REASN")
	private String denailReason;
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@Column(name = "END_DATE")
	private LocalDate endDate;
	public Integer getEligiId() {
		return eligiId;
	}
	public void setEligiId(Integer eligiId) {
		this.eligiId = eligiId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public Long getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Long getHolderSsn() {
		return holderSsn;
	}
	public void setHolderSsn(Long holderSsn) {
		this.holderSsn = holderSsn;
	}
	public Double getBenefitAmt() {
		return benefitAmt;
	}
	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}
	public String getDenailReason() {
		return denailReason;
	}
	public void setDenailReason(String denailReason) {
		this.denailReason = denailReason;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
}
