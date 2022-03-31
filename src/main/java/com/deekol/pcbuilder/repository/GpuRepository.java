package com.deekol.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.pcbuilder.domain.GpuEntity;

public interface GpuRepository extends JpaRepository<GpuEntity, Long> {

}
