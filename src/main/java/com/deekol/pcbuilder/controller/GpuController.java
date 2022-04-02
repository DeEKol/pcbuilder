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

import com.deekol.pcbuilder.domain.GpuEntity;
import com.deekol.pcbuilder.repository.GpuRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/gpu")
@RequiredArgsConstructor
public class GpuController {
	private final GpuRepository gpuRepository;
	
	@GetMapping
	public List<GpuEntity> getAll() {
		return gpuRepository.findAll();
	}
	
	@GetMapping("{id}")
	public GpuEntity getOne(@PathVariable("id") Long id) {
		return gpuRepository.findById(id).get();
	}
	
	@PostMapping
	public GpuEntity create(@RequestBody GpuEntity gpuEntity) {
		return gpuRepository.save(gpuEntity);
	}
	
	@PutMapping("{id}")
	public GpuEntity update(@PathVariable("id") GpuEntity gpuFromDb, @RequestBody GpuEntity gpuEntity) {
		BeanUtils.copyProperties(gpuEntity, gpuFromDb, "id");
		return gpuRepository.save(gpuFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		gpuRepository.deleteById(id);
	}
}
