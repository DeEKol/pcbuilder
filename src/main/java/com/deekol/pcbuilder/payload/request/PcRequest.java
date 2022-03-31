package com.deekol.pcbuilder.payload.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PcRequest {
	private String description;
	private BigDecimal buy;
	private BigDecimal sale;
	
	private BigDecimal spending;
	private Long cpuId;
	private Long gpuId;
	private Long cpuFanId;
	private Long powerUnitId;
	private Long bodyId;
}
