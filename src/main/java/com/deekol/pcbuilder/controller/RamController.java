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

import com.deekol.pcbuilder.domain.RamEntity;
import com.deekol.pcbuilder.payload.request.RamRequest;
import com.deekol.pcbuilder.payload.response.RamResponse;
import com.deekol.pcbuilder.repository.PcRepository;
import com.deekol.pcbuilder.repository.RamRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ram")
@RequiredArgsConstructor
//todo Переделать CrossOrigin
@CrossOrigin
public class RamController {
	private final RamRepository ramRepository;
	private final PcRepository pcRepository;
	
	@GetMapping
	public List<RamResponse> getAll() {
		List<RamEntity> ramEntities = ramRepository.findAll();
		List<RamResponse> ramResponses = new ArrayList<>();
		
		for(RamEntity e : ramEntities) {
			ramResponses.add(ramEntityToRamResponse(e));
		}
		return ramResponses;
	}
	
	@GetMapping("{id}")
	public RamResponse getOne(@PathVariable("id") Long id) {
		RamEntity ramEntity = ramRepository.findById(id).get();
		
		return ramEntityToRamResponse(ramEntity);
	}
	
	@PostMapping
	public RamResponse create(@RequestBody RamRequest ramRequest) {
		RamEntity ramEntity = ramRequestToRamEntity(ramRequest);
		ramRepository.save(ramEntity);
		return ramEntityToRamResponse(ramEntity);
	}
	
	@PutMapping("{id}")
	public RamResponse update(@PathVariable("id") RamEntity ramFromDb, @RequestBody RamRequest ramRequest) {
		RamEntity ramEntity = ramRequestToRamEntity(ramRequest);
		BeanUtils.copyProperties(ramEntity, ramFromDb, "id");
		ramRepository.save(ramFromDb);
		return ramEntityToRamResponse(ramFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		ramRepository.deleteById(id);
	}
	
	RamEntity ramRequestToRamEntity(RamRequest ramRequest) {
		RamEntity ramEntity = new RamEntity();
		ramEntity.setDescription(ramRequest.getDescription());
		ramEntity.setBuy(ramRequest.getBuy());
		ramEntity.setSale(ramRequest.getSale());
		ramEntity.setMaker(ramRequest.getMaker());
		ramEntity.setName(ramRequest.getName());
		ramEntity.setSpecification(ramRequest.getSpecification());
		ramEntity.setType(ramRequest.getType());
		ramEntity.setCapacity(ramRequest.getCapacity());
		ramEntity.setFrequency(ramRequest.getFrequency());
		if (ramRequest.getPcId() != null) {
			ramEntity.setPcEntity(pcRepository.findById(ramRequest.getPcId()).get());
		}
		return ramEntity;
	}
	
	RamResponse ramEntityToRamResponse(RamEntity ramEntity) {
		RamResponse ramResponse = new RamResponse();
		ramResponse.setId(ramEntity.getId());
		ramResponse.setDescription(ramEntity.getDescription());
		ramResponse.setBuy(ramEntity.getBuy());
		ramResponse.setSale(ramEntity.getSale());
		ramResponse.setCreationDate(ramEntity.getCreationDate());
		ramResponse.setMaker(ramEntity.getMaker());
		ramResponse.setName(ramEntity.getName());
		ramResponse.setSpecification(ramEntity.getSpecification());
		ramResponse.setType(ramEntity.getType());
		ramResponse.setCapacity(ramEntity.getCapacity());
		ramResponse.setFrequency(ramEntity.getFrequency());
		if (ramEntity.getPcEntity() != null) {
			ramResponse.setPcId(ramEntity.getPcEntity().getId());
		}
		
		return ramResponse;
	}
}
