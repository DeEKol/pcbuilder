package com.deekol.pcbuilder.domain;

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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cpu_id", referencedColumnName = "id")
	private CpuEntity cpuEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gpu_id", referencedColumnName = "id")
	private GpuEntity gpuEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cpu_fan_id", referencedColumnName = "id")
	private CpuFanEntity cpuFanEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "power_unit_id", referencedColumnName = "id")
	private PowerUnitEntity powerUnitEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "case_id", referencedColumnName = "id")
	private BodyEntity caseEntity;
	
	@OneToMany(mappedBy = "pcEntity")
	private Set<FanEntity> fanEntities;
	
	@OneToMany(mappedBy = "pcEntity")
	private Set<RamEntity> ramEntities;
	
	@OneToMany(mappedBy = "pcEntity")
	private Set<StorageEntity> storageEntities;
}
