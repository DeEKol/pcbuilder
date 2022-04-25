package com.deekol.pcbuilder.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.pcbuilder.domain.CpuFanEntity;
import com.deekol.pcbuilder.repository.CpuFanRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cpufan")
@RequiredArgsConstructor
//todo Переделать CrossOrigin
@CrossOrigin
public class CpuFanController {
	private final CpuFanRepository cpuFanRepository;
	
	@GetMapping
	public List<CpuFanEntity> getAll() {
		return cpuFanRepository.findAll();
	}
	
	@GetMapping("{id}")
	public CpuFanEntity getOne(@PathVariable("id") Long id) {
		return cpuFanRepository.findById(id).get();
	}
	
	@PostMapping
	public CpuFanEntity create(@RequestBody CpuFanEntity cpuFanEntity) {
		return cpuFanRepository.save(cpuFanEntity);
	}
	
	@PutMapping("{id}")
	public CpuFanEntity update(@PathVariable("id") CpuFanEntity cpuFanFromDb, @RequestBody CpuFanEntity cpuFanEntity) {
		BeanUtils.copyProperties(cpuFanEntity, cpuFanFromDb, "id");
		return cpuFanRepository.save(cpuFanFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		cpuFanRepository.deleteById(id);
	}
}
