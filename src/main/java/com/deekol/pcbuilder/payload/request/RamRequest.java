package com.deekol.pcbuilder.payload.request;

import java.math.BigDecimal;

import lombok.Getter;

import lombok.Setter;

@Setter
@Getter
public class RamRequest {
	private String description;
	private BigDecimal buy;
	private BigDecimal sale;
	
	private String maker;
	private String name;
	private String specification;
	
	private String type;
	private Integer capacity;
	private Integer frequency;
	private Long pcId;
}
