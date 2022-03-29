package com.deekol.pcbuilder.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "storage")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StorageEntity extends BasicPart {
	private String type;
	private Integer capacity;
	
	@ManyToOne
	@JoinColumn(name = "pc_id")
	private PcEntity pcEntity;
}
