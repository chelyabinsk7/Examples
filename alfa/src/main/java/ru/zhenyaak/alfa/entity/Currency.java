package ru.zhenyaak.alfa.entity;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Currency {
	
	private Map<String, Double> rates;

	public Map<String, Double> getRates() {
		return rates;
	}
	
}
