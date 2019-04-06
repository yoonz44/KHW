package com.kakao.hw.firstHW.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LocalGov {
	/** 지자체 코드 */
	@Id
	private long code;
	
	/** 지자체명(기관명) */
	private String name;

	public long getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public LocalGov(long code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public LocalGov() {
		super();
	}
}
