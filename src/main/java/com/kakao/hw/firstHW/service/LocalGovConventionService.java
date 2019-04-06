package com.kakao.hw.firstHW.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kakao.hw.firstHW.model.LocalGovConvention;
import com.kakao.hw.firstHW.model.LocalGovConventionDTO;
import com.kakao.hw.firstHW.repository.LocalGovConventionRepo;
import com.kakao.hw.firstHW.repository.LocalGovRepo;
import com.kakao.hw.util.CsvLoader;

@Service
public class LocalGovConventionService {
	private final LocalGovConventionRepo localGovConventionRepo;
	private final LocalGovRepo localGovRepo;
	
	public LocalGovConventionService(LocalGovRepo localGovRepo, LocalGovConventionRepo localGovConventionRepo) {
		this.localGovRepo = localGovRepo;
		this.localGovConventionRepo = localGovConventionRepo;
	}
	
	public List<LocalGovConventionDTO> findAll() {
		return entitiesIntoDTOList(localGovConventionRepo.findAll());
	}
	
	public Optional<LocalGovConvention> findById(Long id) {
		return localGovConventionRepo.findById(id);
	}
	
	public List<LocalGovConventionDTO> findByLocalGovName(String localGovName) {
		return entitiesIntoDTOList(localGovConventionRepo.findByLocalGov_name(localGovName));
	}
	
	public List<String> findByRewardInterestMinRate() {
		return localGovConventionRepo.findByRewardInterestMinRate();
	}
	
	public List<String> findLocalGovNameOrderBySupportedLimit(int limit) {
		return localGovConventionRepo.findLocalGovNameOrderBySupportedLimit(PageRequest.of(0, limit));
	}
	
	@Transactional
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
	
	public List<LocalGovConventionDTO> entitiesIntoDTOList(Iterable<LocalGovConvention> entities) {
		List<LocalGovConventionDTO> dtos = new ArrayList<>();
		
        entities.forEach(entity -> dtos.add(entityIntoDTO(entity)));
        
        return dtos;
	}
	
	public LocalGovConventionDTO entityIntoDTO(LocalGovConvention localGovConvention) {
		LocalGovConventionDTO dto = new LocalGovConventionDTO();
		
		dto.setRegion(localGovConvention.getLocalGov().getName());
		dto.setTarget(localGovConvention.getSupportedTarget());
		dto.setLimit(localGovConvention.getSupportedLimit());
		dto.setRate(localGovConvention.getRewardInterestRate());
		dto.setMgmt(localGovConvention.getManagementPoint());
		dto.setUsage(localGovConvention.getPurpose());
		dto.setInstitute(localGovConvention.getRecommendedOrgan());
		dto.setReception(localGovConvention.getHandlingPoint());
		
		return dto;
	}
}
