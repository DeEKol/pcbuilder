package com.deekol.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.pcbuilder.domain.RamEntity;

public interface RamRepository extends JpaRepository<RamEntity, Long> {

}
