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

import com.deekol.pcbuilder.domain.FanEntity;
import com.deekol.pcbuilder.payload.request.FanRequest;
import com.deekol.pcbuilder.payload.response.FanResponse;
import com.deekol.pcbuilder.repository.FanRepository;
import com.deekol.pcbuilder.repository.PcRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/fan")
@RequiredArgsConstructor
//todo Переделать CrossOrigin
@CrossOrigin
public class FanController {
	private final FanRepository fanRepository;
	private final PcRepository pcRepository;
	
	@GetMapping
	public List<FanResponse> getAll() {
		List<FanEntity> fanEntities = fanRepository.findAll();
		List<FanResponse> fanResponses = new ArrayList<>();
		
		for(FanEntity e : fanEntities) {
			fanResponses.add(fanEntityToFanResponse(e));
		}
		
		return fanResponses;
	}
	
	@GetMapping("{id}")
	public FanResponse getOne(@PathVariable("id") Long id) {
		FanEntity fanEntity = fanRepository.findById(id).get();
		
		return fanEntityToFanResponse(fanEntity);
	}
	
	@PostMapping
	public FanResponse create(@RequestBody FanRequest fanRequest) {
		FanEntity fanEntity = fanRequestToFanEntity(fanRequest);
		fanRepository.save(fanEntity);
		return fanEntityToFanResponse(fanEntity);
	}
	
	@PutMapping("{id}")
	public FanResponse update(@PathVariable("id") FanEntity fanFromDb, @RequestBody FanRequest fanRequest) {
		FanEntity fanEntity = fanRequestToFanEntity(fanRequest);
		BeanUtils.copyProperties(fanEntity, fanFromDb, "id");
		fanRepository.save(fanFromDb);
		return fanEntityToFanResponse(fanFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		fanRepository.deleteById(id);
	}
	
	FanEntity fanRequestToFanEntity(FanRequest fanRequest) {
		FanEntity fanEntity = new FanEntity();
		fanEntity.setDescription(fanRequest.getDescription());
		fanEntity.setBuy(fanRequest.getBuy());
		fanEntity.setSale(fanRequest.getSale());
		fanEntity.setMaker(fanRequest.getMaker());
		fanEntity.setName(fanRequest.getName());
		fanEntity.setSpecification(fanRequest.getSpecification());
		fanEntity.setProportions(fanRequest.getProportions());
		if (fanRequest.getPcId() != null) {
			fanEntity.setPcEntity(pcRepository.findById(fanRequest.getPcId()).get());
		}
		return fanEntity;
	}
	
	FanResponse fanEntityToFanResponse(FanEntity fanEntity) {
		FanResponse fanResponse = new FanResponse();
		fanResponse.setId(fanEntity.getId());
		fanResponse.setDescription(fanEntity.getDescription());
		fanResponse.setBuy(fanEntity.getBuy());
		fanResponse.setSale(fanEntity.getSale());
		fanResponse.setCreationDate(fanEntity.getCreationDate());
		fanResponse.setMaker(fanEntity.getMaker());
		fanResponse.setName(fanEntity.getName());
		fanResponse.setSpecification(fanEntity.getSpecification());
		fanResponse.setProportions(fanEntity.getProportions());
		if (fanEntity.getPcEntity() != null) {
			fanResponse.setPcId(fanEntity.getPcEntity().getId());
		}
		
		return fanResponse;
	}
}
