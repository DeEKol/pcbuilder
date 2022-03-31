package com.deekol.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.pcbuilder.domain.StorageEntity;

public interface StorageRepository extends JpaRepository<StorageEntity, Long> {

}
