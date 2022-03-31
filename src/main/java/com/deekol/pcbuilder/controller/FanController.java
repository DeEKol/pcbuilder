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

import com.deekol.pcbuilder.domain.FanEntity;
import com.deekol.pcbuilder.repository.FanRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/fan")
@RequiredArgsConstructor
public class FanController {
private final FanRepository fanRepository;
	
	@GetMapping
	public List<FanEntity> getAll() {
		return fanRepository.findAll();
	}
	
	@GetMapping("{id}")
	public FanEntity getOne(@PathVariable("id") Long id) {
		return fanRepository.findById(id).get();
	}
	
	@PostMapping
	public FanEntity create(@RequestBody FanEntity fanEntity) {
		return fanRepository.save(fanEntity);
	}
	
	@PutMapping("{id}")
	public FanEntity update(@PathVariable("id") FanEntity fanFromDb, @RequestBody FanEntity fanEntity) {
		BeanUtils.copyProperties(fanEntity, fanFromDb, "id");
		return fanRepository.save(fanFromDb);
	}
	
	@DeleteMapping
	public void delete(@PathVariable("id") Long id) {
		fanRepository.deleteById(id);
	}
}
