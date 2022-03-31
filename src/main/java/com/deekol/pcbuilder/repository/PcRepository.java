package com.deekol.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.pcbuilder.domain.PcEntity;

public interface PcRepository extends JpaRepository<PcEntity, Long> {

}
