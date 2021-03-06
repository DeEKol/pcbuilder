package com.deekol.pcbuilder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "body")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BodyEntity extends BasicPart {
	private String proportions;
	
	//TODO buProportions change to puProportions
	@Column(name = "pu_proportions")
	private String puProportions;
}
