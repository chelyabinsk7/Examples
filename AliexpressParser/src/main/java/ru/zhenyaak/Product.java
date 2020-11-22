package ru.zhenyaak;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Product {

	private List<Results> result;
	
	public Product() {
		
	}

	public List<Results> getResults() {
		return result;
	}

	public void setResults(List<Results> result) {
		this.result = result;
	}
	
}