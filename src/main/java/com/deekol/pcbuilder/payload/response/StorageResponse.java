package com.deekol.pcbuilder.payload.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StorageResponse {
	private Long id;
	private String description;
	private BigDecimal buy;
	private BigDecimal sale;
	
	private String maker;
	private String name;
	private String specification;
	
	private String type;
	private Integer capacity;
	private Long pcId;
}
