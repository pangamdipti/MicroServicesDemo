package com.poc9.microservices.temperatureexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TemperatureExchange {
	
	@Id
	private Long id;
	
	@Column(name ="temperature_from")
	private String from;
	
	@Column(name ="temperature_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	private BigDecimal conversionAddSub;
	private String environment;
	
	public TemperatureExchange() {}

	public TemperatureExchange(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal conversionAddSub) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.conversionAddSub = conversionAddSub;
		
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

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
	
	

}
