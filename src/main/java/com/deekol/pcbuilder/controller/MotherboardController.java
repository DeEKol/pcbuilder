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

import com.deekol.pcbuilder.domain.MotherboardEntity;
import com.deekol.pcbuilder.repository.MotherboardRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/motherboard")
@RequiredArgsConstructor
public class MotherboardController {
	private final MotherboardRepository motherboardRepository;
	
	@GetMapping
	public List<MotherboardEntity> getAll() {
		return motherboardRepository.findAll();
	}
	
	@GetMapping("{id}")
	public MotherboardEntity getOne(@PathVariable("id") Long id) {
		return motherboardRepository.findById(id).get();
	}
	
	@PostMapping
	public MotherboardEntity create(@RequestBody MotherboardEntity motherboardEntity) {
		return motherboardRepository.save(motherboardEntity);
	}
	
	@PutMapping("{id}")
	public MotherboardEntity update(@PathVariable("id") MotherboardEntity motherboardFromDb, @RequestBody MotherboardEntity motherboardEntity) {
		BeanUtils.copyProperties(motherboardEntity, motherboardFromDb, "id");
		return motherboardRepository.save(motherboardFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		motherboardRepository.deleteById(id);
	}
}
