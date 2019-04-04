package com.kakao.hw.firstHW.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.hw.firstHW.model.LocalGovConvention;
import com.kakao.hw.firstHW.model.LocalGovConventionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalGovConventionService {
	@Autowired
	private LocalGovConventionRepo localGovConventionRepo;
	
	private SessionFactory sessionFactory;
	
	public List<LocalGovConvention> findAll() {
		return localGovConventionRepo.findAll();
	}
	
	public Optional<LocalGovConvention> findById(Long id) {
		return localGovConventionRepo.findById(id);
	}
	
	public List<LocalGovConvention> findByLocalGovName(String localGovName) {
		Session session = this.sessionFactory.getCurrentSession();
		TypedQuery<LocalGovConvention> query = session.getNamedQuery("findByLocalGovName");
		query.setParameter("localGovName", localGovName);
		
		return query.getResultList(); 
	}
	
	public LocalGovConvention save(LocalGovConvention lgConvention) {
		return localGovConventionRepo.save(lgConvention);
	}
}
