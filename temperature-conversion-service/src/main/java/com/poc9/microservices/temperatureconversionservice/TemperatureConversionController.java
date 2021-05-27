package com.poc9.microservices.temperatureconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TemperatureConversionController {

	@Autowired
	private TemperatureExchangeProxy proxy;

	@GetMapping("/temperature-conversion-feign/from/{from}/to/{to}/value/{value}")
	public TemperatureConversion calculateTemperatureConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal value) {
		
//		if(from.equals("C") && to.equals("F")){
			TemperatureConversion temperatureConversion = proxy.retrieveExchangeValue(from, to);

			return new TemperatureConversion(temperatureConversion.getId(), from, to, value,
					temperatureConversion.getConversionMultiple(),
					temperatureConversion.getConversionAddSub(),
					value.multiply(temperatureConversion.getConversionMultiple()).add(temperatureConversion.getConversionAddSub()),
					temperatureConversion.getEnvironment() + " " + "feign");
//		}
//		else if(from.equals("F") && to.equals("C")){
//			TemperatureConversion temperatureConversion = proxy.retrieveExchangeValue(from, to);
//
//			return new TemperatureConversion(temperatureConversion.getId(), from, to, value,
//					temperatureConversion.getConversionMultiple(),
//					temperatureConversion.getConversionAddSub(),
//					(value.add(temperatureConversion.getConversionAddSub()).multiply(temperatureConversion.getConversionMultiple())),
//					temperatureConversion.getEnvironment() + " " + "feign");
//		}
		
//		return null;

		

		/*
		 * HashMap<String, String> uriVariables = new HashMap<>();
		 * uriVariables.put("from", from); uriVariables.put("to", to);
		 * 
		 * ResponseEntity<TemperatureConversion> responseEntity = new RestTemplate()
		 * .getForEntity(
		 * "http://localhost:8000/temperature-exchange/from/{from}/to/{to}",
		 * TemperatureConversion.class , uriVariables);
		 * 
		 * TemperatureConversion temperatureConversion = responseEntity.getBody();
		 * 
		 * return new TemperatureConversion(temperatureConversion.getId(), from, to,
		 * value, temperatureConversion.getConversionMultiple(),
		 * value.multiply(temperatureConversion.getConversionMultiple()),
		 * temperatureConversion.getEnvironment()+" "+"rest template");
		 */
	}
	
	@GetMapping("/temperature-conversion/from/{from}/to/{to}/value/{value}")
	public TemperatureConversion calculateTempConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal value) {
		
		  HashMap<String, String> uriVariables = new HashMap<>();
		  uriVariables.put("from", from); uriVariables.put("to", to);
		  
		  ResponseEntity<TemperatureConversion> responseEntity = new RestTemplate()
		  .getForEntity(
		  "http://localhost:8000/temperature-exchange/from/{from}/to/{to}",
		  TemperatureConversion.class , uriVariables);
		  
		  TemperatureConversion temperatureConversion = responseEntity.getBody();
		  
		  //if(from.equals("C") && to.equals("F")) {
				return new TemperatureConversion(temperatureConversion.getId(), from, to, value,
						temperatureConversion.getConversionMultiple(),
						temperatureConversion.getConversionAddSub(),
						value.multiply(temperatureConversion.getConversionMultiple()).add(temperatureConversion.getConversionAddSub()),
						temperatureConversion.getEnvironment() + " " + "rest template");
		//	}
//		  else if(from.equals("F") && to.equals("C")){
//
//				return new TemperatureConversion(temperatureConversion.getId(), from, to, value,
//						temperatureConversion.getConversionMultiple(),
//						temperatureConversion.getConversionAddSub(),
//						(value.add(temperatureConversion.getConversionAddSub()).multiply(temperatureConversion.getConversionMultiple())),
//						temperatureConversion.getEnvironment() + " " + "rest template");
//			}
		  
//		  return null;
	}

}
