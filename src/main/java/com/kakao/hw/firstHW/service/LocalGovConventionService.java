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
import com.kakao.hw.util.CsvLoader;

@Service
public class LocalGovConventionService {
	private final LocalGovConventionRepo localGovConventionRepo;
	
	public LocalGovConventionService(LocalGovConventionRepo localGovConventionRepo) {
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
	
	@Transactional
	public List<String> findByRewardInterestMinRate() {
		List<String> tmp = localGovConventionRepo.findFirstByRewardInterestMinRate();
//		
//		List<String> result = tmp
//				.map(vo -> {
//					LocalGovConvention temp = new LocalGovConvention();
//					temp.setSupportedLimit(vo.getSupportedLimit().split("~")[0].replace("%", ""));
//					temp.setLocalGov(vo.getLocalGov());
//					
//					return temp;
//				})
//				.sorted(Comparator.comparing(LocalGovConvention::getSupportedLimit))
//				.limit(1)
//				.map(vo -> vo.getLocalGov().getName())
//				.collect(Collectors.toList());
		
		return tmp;
	}
	
	public List<String> findLocalGovNameOrderBySupportedLimit(int limit) {
		return localGovConventionRepo.findLocalGovNameOrderBySupportedLimit(PageRequest.of(0, limit));
	}
	
	@Transactional
	public LocalGovConvention save(LocalGovConvention lgConvention) {
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
