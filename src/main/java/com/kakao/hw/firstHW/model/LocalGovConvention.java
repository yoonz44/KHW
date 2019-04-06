package com.kakao.hw.firstHW.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LocalGovConvention {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** 지자체 코드 */
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn
	private LocalGov localGov;
	
	/** 지원대상 */
	private String supportedTarget;
	
	/** 용도 */
	private String purpose;
	
	/** 지원한도 */
	private String supportedLimit;
	
	/** 이차보전 */
	private String rewardInterestRate;
	
	/** 이차보전 최저 */
	private double rewardInterestMinRate;
	
	/** 이차보전 최대*/
	private double rewardInterestMaxRate;
	
	/** 추천기관 */
	private String recommendedOrgan;
	
	/** 관리점 */
	private String managementPoint;
	
	/** 취급점 */
	private String handlingPoint;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalGov getLocalGov() {
		return localGov;
	}

	public String getSupportedTarget() {
		return supportedTarget;
	}

	public void setSupportedTarget(String supportedTarget) {
		this.supportedTarget = supportedTarget;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSupportedLimit() {
		return supportedLimit;
	}

	public void setSupportedLimit(String supportedLimit) {
		this.supportedLimit = supportedLimit;
	}

	public String getRewardInterestRate() {
		return rewardInterestRate;
	}

	public void setRewardInterestRate(String rewardInterestRate) {
		this.rewardInterestRate = rewardInterestRate;
	}

	public double getRewardInterestMinRate() {
		return rewardInterestMinRate;
	}

	public void setRewardInterestMinRate(double rewardInterestMinRate) {
		this.rewardInterestMinRate = rewardInterestMinRate;
	}

	public double getRewardInterestMaxRate() {
		return rewardInterestMaxRate;
	}

	public void setRewardInterestMaxRate(double rewardInterestMaxRate) {
		this.rewardInterestMaxRate = rewardInterestMaxRate;
	}

	public String getRecommendedOrgan() {
		return recommendedOrgan;
	}

	public void setRecommendedOrgan(String recommendedOrgan) {
		this.recommendedOrgan = recommendedOrgan;
	}

	public String getManagementPoint() {
		return managementPoint;
	}

	public void setManagementPoint(String managementPoint) {
		this.managementPoint = managementPoint;
	}

	public String getHandlingPoint() {
		return handlingPoint;
	}

	public void setHandlingPoint(String handlingPoint) {
		this.handlingPoint = handlingPoint;
	}

	public LocalGovConvention(Long id, LocalGov localGov, String supportedTarget, String purpose, String supportedLimit,
			String rewardInterestRate, double rewardInterestMinRate, double rewardInterestMaxRate,
			String recommendedOrgan, String managementPoint, String handlingPoint) {
		super();
		this.id = id;
		this.localGov = localGov;
		this.supportedTarget = supportedTarget;
		this.purpose = purpose;
		this.supportedLimit = supportedLimit;
		this.rewardInterestRate = rewardInterestRate;
		this.rewardInterestMinRate = rewardInterestMinRate;
		this.rewardInterestMaxRate = rewardInterestMaxRate;
		this.recommendedOrgan = recommendedOrgan;
		this.managementPoint = managementPoint;
		this.handlingPoint = handlingPoint;
	}

	public LocalGovConvention() {
		super();
	}
}