package ru.zhenyaak.jackson.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Object {
	private String dt_txt;
	private Main main;
	
	public Object() {
		
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	
}
