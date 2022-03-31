package com.deekol.pcbuilder.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pc")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PcEntity extends Basic {
	private BigDecimal spending;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	@JoinColumn(name = "cpu_id", referencedColumnName = "id")
	private CpuEntity cpuEntity;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	@JoinColumn(name = "gpu_id", referencedColumnName = "id")
	private GpuEntity gpuEntity;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	@JoinColumn(name = "cpu_fan_id", referencedColumnName = "id")
	private CpuFanEntity cpuFanEntity;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	@JoinColumn(name = "power_unit_id", referencedColumnName = "id")
	private PowerUnitEntity powerUnitEntity;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	@JoinColumn(name = "body_id", referencedColumnName = "id")
	private BodyEntity bodyEntity;
	
	@OneToMany(mappedBy = "pcEntity")
	private Set<FanEntity> fanEntities;
	
	@OneToMany(mappedBy = "pcEntity")
	private Set<RamEntity> ramEntities;
	
	@OneToMany(mappedBy = "pcEntity", orphanRemoval = false)
	private Set<StorageEntity> storageEntities;


	
	
	
}
