package com.kakao.hw.firstHW.model;

public class LocalGovConventionDTO {
	/** 고유 아이디 */
	private Long id;
	
	/** 지자체명(기관명) */
	private String localGovName;
	
	/** 지원대상 */
	private String supportedTarget;
	
	/** 용도 */
	private String purpose;
	
	/** 지원한도 */
	private String supportedLimit;
	
	/** 이차보전 */
	private String rewardInterestRate;
	
	/** 추천기관 */
	private String recommendedOrgan;
	
	/** 관리점 */
	private String managementPoint;
	
	/** 취급점 */
	private String handlingPoint;

	public Long getId() {
		return id;
	}

	public String getLocalGovName() {
		return localGovName;
	}

	public String getSupportedTarget() {
		return supportedTarget;
	}

	public String getPurpose() {
		return purpose;
	}

	public String getSupportedLimit() {
		return supportedLimit;
	}

	public String getRewardInterestRate() {
		return rewardInterestRate;
	}

	public String getRecommendedOrgan() {
		return recommendedOrgan;
	}

	public String getManagementPoint() {
		return managementPoint;
	}

	public String getHandlingPoint() {
		return handlingPoint;
	}

	public LocalGovConventionDTO(Long id, String localGovName, String supportedTarget, String purpose,
			String supportedLimit, String rewardInterestRate, String recommendedOrgan, String managementPoint,
			String handlingPoint) {
		super();
		this.id = id;
		this.localGovName = localGovName;
		this.supportedTarget = supportedTarget;
		this.purpose = purpose;
		this.supportedLimit = supportedLimit;
		this.rewardInterestRate = rewardInterestRate;
		this.recommendedOrgan = recommendedOrgan;
		this.managementPoint = managementPoint;
		this.handlingPoint = handlingPoint;
	}
}
