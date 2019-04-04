package com.kakao.hw.firstHW.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kakao.hw.firstHW.model.LocalGovConvention;

public interface LocalGovConventionRepo extends JpaRepository<LocalGovConvention, Long> {

	public List<LocalGovConvention> findByLocalGovName(String localGovName);
	
	@Query("SELECT a.localGovName FROM LocalGovConvention a "
			+ "WHERE a.rewardInterestMinRate = "
			+ "(SELECT MIN(b.rewardInterestMinRate) FROM LocalGovConvention b)")
	public List<String> findByRewardInterestMinRate();
	
	@Query("SELECT a.localGovName FROM LocalGovConvention a ORDER BY a.supportedLimit DESC, a.rewardInterestMinRate")
	public List<String> findLocalGovNameOrderBySupportedLimit(Pageable pageable);
}
