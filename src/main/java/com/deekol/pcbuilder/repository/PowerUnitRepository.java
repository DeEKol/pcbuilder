package com.deekol.pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.pcbuilder.domain.PowerUnitEntity;

public interface PowerUnitRepository extends JpaRepository<PowerUnitEntity, Long> {

}
