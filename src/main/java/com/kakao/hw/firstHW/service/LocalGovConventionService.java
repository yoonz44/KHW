package com.kakao.hw.firstHW.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kakao.hw.firstHW.model.LocalGovConvention;
import com.kakao.hw.firstHW.repository.LocalGovConventionRepo;
import com.kakao.hw.util.CsvLoader;

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
	
	public List<String> findByRewardInterestMinRate() {
		return localGovConventionRepo.findByRewardInterestMinRate();
	}
	
	public List<String> findLocalGovNameOrderBySupportedLimit(int limit) {
		return localGovConventionRepo.findLocalGovNameOrderBySupportedLimit(PageRequest.of(0, limit));
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

	public List<LocalGovConvention> saveAll(MultipartFile multipartFile) {
		return localGovConventionRepo.saveAll(CsvLoader.loadCsvList(LocalGovConvention.class, multipartFile));
	}
}
