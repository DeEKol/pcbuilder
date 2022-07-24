package com.deekol.pcbuilder.payload.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PcResponse {
	private Long id;
	private String description;
	private BigDecimal buy;
	private BigDecimal sale;
	
	private LocalDate creationDate;
	
	private BigDecimal spending;
	private Long cpuId;
	private Long gpuId;
	private Long cpuFanId;
	private Long powerUnitId;
	private Long bodyId;
}
