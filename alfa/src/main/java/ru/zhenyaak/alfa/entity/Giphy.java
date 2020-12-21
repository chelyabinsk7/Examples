package ru.zhenyaak.alfa.entity;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Giphy {
	
	private Map<String, Object> data;
	
	public Map<String, Object> getData() {
		return data;
	}

}
