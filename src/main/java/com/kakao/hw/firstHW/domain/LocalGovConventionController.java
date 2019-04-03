package com.kakao.hw.firstHW.domain;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakao.hw.firstHW.model.LocalGovConvention;
import com.kakao.hw.firstHW.service.LocalGovConventionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/lgc")
@Slf4j
@RequiredArgsConstructor
public class LocalGovConventionController {
	private LocalGovConventionService localGovConventionService;
	
	@GetMapping
	public ResponseEntity<List<LocalGovConvention>> findAll() {
		return ResponseEntity.ok(localGovConventionService.findAll());
	}
	
	@GetMapping("/{localGovName}")
	public ResponseEntity<List<LocalGovConvention>> findByLocalGovName(@PathVariable String localGovName) {
		return ResponseEntity.ok(localGovConventionService.findByLocalGovName(localGovName));
	}
	
	@PostMapping
	public ResponseEntity<LocalGovConvention> insert(@Valid @RequestBody LocalGovConvention localGovConvention) {
		if (localGovConventionService.findById(localGovConvention.getId()).isPresent()) {
			log.error(localGovConvention.getId() + " is existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(localGovConventionService.save(localGovConvention));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LocalGovConvention> update(@PathVariable Long id, @Valid @RequestBody LocalGovConvention localGovConvention) {
		if (!localGovConventionService.findById(id).isPresent()) {
			log.error(id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(localGovConventionService.save(localGovConvention));
	}
}