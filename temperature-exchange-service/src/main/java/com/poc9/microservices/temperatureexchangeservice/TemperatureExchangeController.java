package com.poc9.microservices.temperatureexchangeservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureExchangeController {
	
	@Autowired TemperatureExchangeRepository repository;
	
	@Autowired Environment environment;
	
	@GetMapping("/temperature-exchange/from/{from}/to/{to}")
	public TemperatureExchange retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		TemperatureExchange temperatureExchange =  repository.findByFromAndTo(from, to);
		
		if(temperatureExchange == null) {
			throw new RuntimeException("Unable to Find data for "+from+" to "+to);
		}
		
		String port = environment.getProperty("local.server.port");
		temperatureExchange.setEnvironment(port);
		return temperatureExchange;
		
	}
}
