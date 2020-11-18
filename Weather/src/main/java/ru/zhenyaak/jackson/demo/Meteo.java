package ru.zhenyaak.jackson.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Meteo {
    private int cnt;
    private City city;
    private List<Object> list;
    
	public Meteo() {
		
	}
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Watchlist [cnt=" + cnt + ", city=" + city + ", list=" + list + "]";
	}

	
}

