package com.kakao.hw.firstHW.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Service;

import com.kakao.hw.firstHW.model.LocalGovConvention;
import com.kakao.hw.firstHW.model.LocalGovConventionDTO;
import com.kakao.hw.firstHW.repository.LocalGovConventionRepo;

@Service
public class LocalGovConventionService {
	private final LocalGovConventionRepo localGovConventionRepo;
	
	public LocalGovConventionService(LocalGovConventionRepo localGovConventionRepo, EntityManagerFactory factory) {
		this.localGovConventionRepo = localGovConventionRepo;
	}
	
	public List<LocalGovConvention> findAll() {
		return localGovConventionRepo.findAll();
	}
	
	public Optional<LocalGovConvention> findById(Long id) {
		return localGovConventionRepo.findById(id);
	}
	
	public List<LocalGovConvention> findByLocalGovName(String localGovName) {
		return localGovConventionRepo.findByLocalGovName(localGovName);
	}
	
	public List<LocalGovConventionDTO> findByRewardInterestMinRate() {
		return localGovConventionRepo.findByRewardInterestMinRate();
	}
	
	public LocalGovConvention save(LocalGovConvention lgConvention) {
		if (lgConvention.getRewardInterestRate() != null) {
			String[] tempAry = lgConvention.getRewardInterestRate().split("~");
			
			if (tempAry.length > 1) {
				lgConvention.setRewardInterestMinRate(Double.parseDouble(tempAry[0].replace("%", "")));
				lgConvention.setRewardInterestMaxRate(Double.parseDouble(tempAry[1].replace("%", "")));
			} else {
				lgConvention.setRewardInterestMinRate(Double.parseDouble(tempAry[0].replace("%", "")));
				lgConvention.setRewardInterestMaxRate(Double.parseDouble(tempAry[0].replace("%", "")));
			}
		}
		
		return localGovConventionRepo.save(lgConvention);
	}
}
