package com.deekol.pcbuilder.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "fan")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class FanEntity extends BasicPart {
	private String proportions;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pc_id")
	private PcEntity pcEntity;
}
