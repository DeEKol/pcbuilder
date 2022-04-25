package com.deekol.pcbuilder.controller;

import java.util.ArrayList;
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

import com.deekol.pcbuilder.domain.PcEntity;
import com.deekol.pcbuilder.payload.request.PcRequest;
import com.deekol.pcbuilder.payload.response.PcResponse;
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
//todo Переделать CrossOrigin
@CrossOrigin
public class PcController {
	private final PcRepository pcRepository;
	private final CpuRepository cpuRepository;
	private final GpuRepository gpuRepository;
	private final CpuFanRepository cpuFanRepository;
	private final PowerUnitRepository powerUnitRepository;
	private final BodyRepository bodyRepository;
	
	@GetMapping
	public List<PcResponse> getAll() {
		List<PcEntity> pcEntities = pcRepository.findAll();
		List<PcResponse> pcResponses = new ArrayList<>();
		
		for(PcEntity e : pcEntities) {
			pcResponses.add(pcEntityToPcResponse(e));
		}
		return pcResponses;
	}
	
	@GetMapping("{id}")
	public PcResponse getOne(@PathVariable("id") Long id) {
		PcEntity pcEntity = pcRepository.findById(id).get();
		
		return pcEntityToPcResponse(pcEntity);
	}
	
	@PostMapping
	public PcResponse create(@RequestBody PcRequest pcRequest) {
		PcEntity pcEntity = pcRequestToPcEntity(pcRequest);
		pcRepository.save(pcEntity);
		return pcEntityToPcResponse(pcEntity);
	}
	
	@PutMapping("{id}")
	public PcResponse update(@PathVariable("id") PcEntity pcFromDb, @RequestBody PcRequest pcRequest) {
		PcEntity pcEntity = pcRequestToPcEntity(pcRequest);
		BeanUtils.copyProperties(pcEntity, pcFromDb, "id");
		pcRepository.save(pcFromDb);
		return pcEntityToPcResponse(pcFromDb);
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
	
	PcResponse pcEntityToPcResponse(PcEntity pcEntity) {
		PcResponse pcResponse = new PcResponse();
		pcResponse.setId(pcEntity.getId());
		pcResponse.setDescription(pcEntity.getDescription());
		pcResponse.setBuy(pcEntity.getBuy());
		pcResponse.setSale(pcEntity.getSale());
		pcResponse.setSpending(pcEntity.getSpending());
		if (pcEntity.getCpuEntity() != null) {
			pcResponse.setCpuId(pcEntity.getCpuEntity().getId());
		}
		if (pcEntity.getGpuEntity() != null) {
			pcResponse.setGpuId(pcEntity.getGpuEntity().getId());
		}
		if (pcEntity.getCpuFanEntity() != null) {
			pcResponse.setCpuFanId(pcEntity.getCpuFanEntity().getId());
		}
		if (pcEntity.getPowerUnitEntity() != null) {
			pcResponse.setPowerUnitId(pcEntity.getPowerUnitEntity().getId());
		}
		if (pcEntity.getBodyEntity() != null) {
			pcResponse.setBodyId(pcEntity.getBodyEntity().getId());
		}
		
		return pcResponse;
	}
}
