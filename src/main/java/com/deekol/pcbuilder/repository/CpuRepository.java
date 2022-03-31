package com.deekol.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.pcbuilder.domain.CpuEntity;

public interface CpuRepository extends JpaRepository<CpuEntity, Long> {

}
