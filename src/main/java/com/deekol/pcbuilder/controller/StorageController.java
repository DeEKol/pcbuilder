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

import com.deekol.pcbuilder.domain.StorageEntity;
import com.deekol.pcbuilder.repository.StorageRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/storage")
@RequiredArgsConstructor
public class StorageController {
private final StorageRepository storageRepository;
	
	@GetMapping
	public List<StorageEntity> getAll() {
		return storageRepository.findAll();
	}
	
	@GetMapping("{id}")
	public StorageEntity getOne(@PathVariable("id") Long id) {
		return storageRepository.findById(id).get();
	}
	
	@PostMapping
	public StorageEntity create(@RequestBody StorageEntity storageEntity) {
		return storageRepository.save(storageEntity);
	}
	
	@PutMapping("{id}")
	public StorageEntity update(@PathVariable("id") StorageEntity storageFromDb, @RequestBody StorageEntity storageEntity) {
		BeanUtils.copyProperties(storageEntity, storageFromDb, "id");
		return storageRepository.save(storageFromDb);
	}
	
	@DeleteMapping
	public void delete(@PathVariable("id") Long id) {
		storageRepository.deleteById(id);
	}
}
