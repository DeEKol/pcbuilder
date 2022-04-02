package com.deekol.pcbuilder.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.pcbuilder.domain.CpuEntity;
import com.deekol.pcbuilder.repository.CpuRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cpu")
@RequiredArgsConstructor
public class CpuController {
	private final CpuRepository cpuRepository;
	
	@GetMapping
	public List<CpuEntity> getAll() {
		return cpuRepository.findAll();
	}
	
	@GetMapping("{id}")
	public CpuEntity getOne(@PathVariable("id") Long id) {
		return cpuRepository.findById(id).get();
	}
	
	@PostMapping
	public CpuEntity create(@RequestBody CpuEntity cpuEntity) {
		return cpuRepository.save(cpuEntity);
	}
	
	@PutMapping("{id}")
	public CpuEntity update(@PathVariable("id") CpuEntity cpuFromDb, @RequestBody CpuEntity cpuEntity) {
		BeanUtils.copyProperties(cpuEntity, cpuFromDb, "id");
		return cpuRepository.save(cpuFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		cpuRepository.deleteById(id);
	}
}
