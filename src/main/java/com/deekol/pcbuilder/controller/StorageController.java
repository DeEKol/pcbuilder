package com.deekol.pcbuilder.controller;

import java.util.ArrayList;
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
import com.deekol.pcbuilder.payload.request.StorageRequest;
import com.deekol.pcbuilder.payload.response.StorageResponse;
import com.deekol.pcbuilder.repository.PcRepository;
import com.deekol.pcbuilder.repository.StorageRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/storage")
@RequiredArgsConstructor
public class StorageController {
	private final StorageRepository storageRepository;
	private final PcRepository pcRepository;
	
	@GetMapping
	public List<StorageResponse> getAll() {
		List<StorageEntity> storageEntities = storageRepository.findAll();
		List<StorageResponse> storageResponses = new ArrayList<>();
		
		for(StorageEntity e : storageEntities) {
			storageResponses.add(storageEntityToStorageResponse(e));
		}
		return storageResponses;
	}
	
	@GetMapping("{id}")
	public StorageResponse getOne(@PathVariable("id") Long id) {
		StorageEntity storageEntity = storageRepository.findById(id).get();
		
		return storageEntityToStorageResponse(storageEntity);
	}
	
	@PostMapping
	public StorageResponse create(@RequestBody StorageRequest storageRequest) {
		StorageEntity storageEntity = storageRequestToStorageEntity(storageRequest);
		storageRepository.save(storageEntity);
		return storageEntityToStorageResponse(storageEntity);
	}
	
	@PutMapping("{id}")
	public StorageResponse update(@PathVariable("id") StorageEntity storageFromDb, @RequestBody StorageRequest storageRequest) {
		StorageEntity storageEntity = storageRequestToStorageEntity(storageRequest);
		BeanUtils.copyProperties(storageEntity, storageFromDb, "id");
		storageRepository.save(storageFromDb);
		return storageEntityToStorageResponse(storageFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		storageRepository.deleteById(id);
	}
	
	StorageEntity storageRequestToStorageEntity(StorageRequest storageRequest) {
		StorageEntity storageEntity = new StorageEntity();
		storageEntity.setDescription(storageRequest.getDescription());
		storageEntity.setBuy(storageRequest.getBuy());
		storageEntity.setSale(storageRequest.getSale());
		storageEntity.setMaker(storageRequest.getMaker());
		storageEntity.setName(storageRequest.getName());
		storageEntity.setSpecification(storageRequest.getSpecification());
		storageEntity.setType(storageRequest.getType());
		storageEntity.setCapacity(storageRequest.getCapacity());
		if (storageRequest.getPcId() != null) {
			storageEntity.setPcEntity(pcRepository.findById(storageRequest.getPcId()).get());
		}
		return storageEntity;
	}
	
	StorageResponse storageEntityToStorageResponse(StorageEntity storageEntity) {
		StorageResponse storageResponse = new StorageResponse();
		storageResponse.setId(storageEntity.getId());
		storageResponse.setDescription(storageEntity.getDescription());
		storageResponse.setBuy(storageEntity.getBuy());
		storageResponse.setSale(storageEntity.getSale());
		storageResponse.setMaker(storageEntity.getMaker());
		storageResponse.setName(storageEntity.getName());
		storageResponse.setSpecification(storageEntity.getSpecification());
		storageResponse.setType(storageEntity.getType());
		storageResponse.setCapacity(storageEntity.getCapacity());
		if (storageEntity.getPcEntity() != null) {
			storageResponse.setPcId(storageEntity.getPcEntity().getId());
		}
		
		return storageResponse;
	}
}
