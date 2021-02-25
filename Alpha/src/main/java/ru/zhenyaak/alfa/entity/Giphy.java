package ru.zhenyaak.alfa.entity;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Giphy {
	
	@Getter
	private Map<String, Object> data;

}
