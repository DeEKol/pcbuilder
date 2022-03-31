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

import com.deekol.pcbuilder.domain.PcEntity;
import com.deekol.pcbuilder.payload.request.PcRequest;
import com.deekol.pcbuilder.repository.BodyRepository;
import com.deekol.pcbuilder.repository.CpuFanRepository;
import com.deekol.pcbuilder.repository.CpuRepository;
import com.deekol.pcbuilder.repository.GpuRepository;
import com.deekol.pcbuilder.repository.PcRepository;
import com.deekol.pcbuilder.repository.PowerUnitRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pc")
@RequiredArgsConstructor
public class PcController {
	private final PcRepository pcRepository;
	private final CpuRepository cpuRepository;
	private final GpuRepository gpuRepository;
	private final CpuFanRepository cpuFanRepository;
	private final PowerUnitRepository powerUnitRepository;
	private final BodyRepository bodyRepository;
	
	@GetMapping
	public List<PcEntity> getAll() {
		return pcRepository.findAll();
	}
	
	@GetMapping("{id}")
	public PcEntity getOne(@PathVariable("id") Long id) {
		return pcRepository.findById(id).get();
	}
	
	@PostMapping
	public PcEntity create(@RequestBody PcRequest pcRequest) {
		return pcRepository.save(pcRequestToPcEntity(pcRequest));
	}
	
	@PutMapping("{id}")
	public PcEntity update(@PathVariable("id") PcEntity pcFromDb, @RequestBody PcRequest pcRequest) {
		PcEntity pcEntity = pcRequestToPcEntity(pcRequest);
		BeanUtils.copyProperties(pcEntity, pcFromDb, "id");
		return pcRepository.save(pcFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		pcRepository.deleteById(id);
	}
	
	PcEntity pcRequestToPcEntity(PcRequest pcRequest) {
		PcEntity pcEntity = new PcEntity();
		pcEntity.setDescription(pcRequest.getDescription());
		pcEntity.setBuy(pcRequest.getBuy());
		pcEntity.setSale(pcRequest.getSale());
		pcEntity.setSpending(pcRequest.getSpending());
		if (pcRequest.getCpuId() != null) {
			pcEntity.setCpuEntity(cpuRepository.findById(pcRequest.getCpuId()).get());
		}
		if (pcRequest.getGpuId() != null) {
			pcEntity.setGpuEntity(gpuRepository.findById(pcRequest.getGpuId()).get());
		}
		if (pcRequest.getCpuFanId() != null) {
			pcEntity.setCpuFanEntity(cpuFanRepository.findById(pcRequest.getCpuFanId()).get());
		}
		if (pcRequest.getPowerUnitId() != null) {
			pcEntity.setPowerUnitEntity(powerUnitRepository.findById(pcRequest.getPowerUnitId()).get());
		}
		if (pcRequest.getBodyId() != null) {
			pcEntity.setBodyEntity(bodyRepository.findById(pcRequest.getBodyId()).get());
		}
		return pcEntity;
	}
}
