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

import com.deekol.pcbuilder.domain.PowerUnitEntity;
import com.deekol.pcbuilder.repository.PowerUnitRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/powerunit")
@RequiredArgsConstructor
//todo Переделать CrossOrigin
@CrossOrigin
public class PowerUnitController {
	private final PowerUnitRepository powerUnitRepository;
	
	@GetMapping
	public List<PowerUnitEntity> getAll() {
		return powerUnitRepository.findAll();
	}
	
	@GetMapping("{id}")
	public PowerUnitEntity getOne(@PathVariable("id") Long id) {
		return powerUnitRepository.findById(id).get();
	}
	
	@PostMapping
	public PowerUnitEntity create(@RequestBody PowerUnitEntity powerUnitEntity) {
		return powerUnitRepository.save(powerUnitEntity);
	}
	
	@PutMapping("{id}")
	public PowerUnitEntity update(@PathVariable("id") PowerUnitEntity powerUnitFromDb, @RequestBody PowerUnitEntity powerUnitEntity) {
		BeanUtils.copyProperties(powerUnitEntity, powerUnitFromDb, "id");
		return powerUnitRepository.save(powerUnitFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		powerUnitRepository.deleteById(id);
	}
}
