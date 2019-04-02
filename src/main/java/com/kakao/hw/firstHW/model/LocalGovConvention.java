package com.kakao.hw.firstHW.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LocalGovConvention {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** 구분 */
	private Long id;
	
	/** 지자체명(기관명) */
	private String localGovName;
	
	/** 지원대상 */
	private String supportedTarget;
	
	/** 용도 */
	private String usage;
	
	/** 지원한도 */
	private String supportedLimit;
	
	/** 이차보전 */
	private double rewardInterestRate;
	
	/** 추천기관 */
	private String recommendedOrgan;
	
	/** 관리점 */
	private String managementPoint;
	
	/** 취급점 */
	private String handlingPoint;
}