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

import com.deekol.pcbuilder.domain.BodyEntity;
import com.deekol.pcbuilder.repository.BodyRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/body")
@RequiredArgsConstructor
public class BodyController {
	private final BodyRepository bodyRepository;
	
	@GetMapping
	public List<BodyEntity> getAll() {
		return bodyRepository.findAll();
	}
	
	@GetMapping("{id}")
	public BodyEntity getOne(@PathVariable("id") Long id) {
		return bodyRepository.findById(id).get();
	}
	
	@PostMapping
	public BodyEntity create(@RequestBody BodyEntity bodyEntity) {
		return bodyRepository.save(bodyEntity);
	}
	
	@PutMapping("{id}")
	public BodyEntity update(@PathVariable("id") BodyEntity bodyFromDb, @RequestBody BodyEntity bodyEntity) {
		BeanUtils.copyProperties(bodyEntity, bodyFromDb, "id");
		return bodyRepository.save(bodyFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		bodyRepository.deleteById(id);
	}
}
