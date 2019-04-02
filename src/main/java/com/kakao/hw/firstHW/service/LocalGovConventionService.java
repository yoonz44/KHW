package com.kakao.hw.firstHW.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kakao.hw.firstHW.model.LocalGovConvention;
import com.kakao.hw.firstHW.model.LocalGovConventionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalGovConventionService {
	private LocalGovConventionRepo localGovConventionRepo;
	
	public List<LocalGovConvention> findAll() {
		return localGovConventionRepo.findAll();
	}
	
	public Optional<LocalGovConvention> findById(Long id) {
		return localGovConventionRepo.findById(id);
	}
	
	public LocalGovConvention save(LocalGovConvention lgConvention) {
		return localGovConventionRepo.save(lgConvention);
	}

	public void updateById(LocalGovConvention lgConvention) {
		localGovConventionRepo.save(lgConvention);
	}
}
