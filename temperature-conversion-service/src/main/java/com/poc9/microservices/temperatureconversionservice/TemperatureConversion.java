package com.poc9.microservices.temperatureconversionservice;

import java.math.BigDecimal;

public class TemperatureConversion {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal value;
	private BigDecimal conversionMultiple;
	private BigDecimal conversionAddSub;
	private BigDecimal totalCalculatedTemp;
	private String environment;
	
	public TemperatureConversion() {}

	public TemperatureConversion(Long id, String from, String to, BigDecimal value, BigDecimal conversionMultiple,
			BigDecimal conversionAddSub, BigDecimal totalCalculatedTemp, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.value = value;
		this.conversionMultiple = conversionMultiple;
		this.conversionAddSub = conversionAddSub;
		this.totalCalculatedTemp = totalCalculatedTemp;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	public BigDecimal getConversionAddSub() {
		return conversionAddSub;
	}

	public void setConversionAddSub(BigDecimal conversionAddSub) {
		this.conversionAddSub = conversionAddSub;
	}

	public BigDecimal getTotalCalculatedTemp() {
		return totalCalculatedTemp;
	}

	public void setTotalCalculatedTemp(BigDecimal totalCalculatedTemp) {
		this.totalCalculatedTemp = totalCalculatedTemp;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
	
	

}
