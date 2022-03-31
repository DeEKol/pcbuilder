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

import com.deekol.pcbuilder.domain.RamEntity;
import com.deekol.pcbuilder.repository.RamRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ram")
@RequiredArgsConstructor
public class RamController {
	private final RamRepository ramRepository;
	
	@GetMapping
	public List<RamEntity> getAll() {
		return ramRepository.findAll();
	}
	
	@GetMapping("{id}")
	public RamEntity getOne(@PathVariable("id") Long id) {
		return ramRepository.findById(id).get();
	}
	
	@PostMapping
	public RamEntity create(@RequestBody RamEntity ramEntity) {
		return ramRepository.save(ramEntity);
	}
	
	@PutMapping("{id}")
	public RamEntity update(@PathVariable("id") RamEntity ramFromDb, @RequestBody RamEntity ramEntity) {
		BeanUtils.copyProperties(ramEntity, ramFromDb, "id");
		return ramRepository.save(ramFromDb);
	}
	
	@DeleteMapping
	public void delete(@PathVariable("id") Long id) {
		ramRepository.deleteById(id);
	}
}
