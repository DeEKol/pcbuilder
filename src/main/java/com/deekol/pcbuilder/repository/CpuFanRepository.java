package com.deekol.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.pcbuilder.domain.CpuFanEntity;

public interface CpuFanRepository extends JpaRepository<CpuFanEntity, Long> {

}
