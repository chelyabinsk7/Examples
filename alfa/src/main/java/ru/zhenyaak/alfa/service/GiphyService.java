package ru.zhenyaak.alfa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.zhenyaak.alfa.client.GiphyClient;
import ru.zhenyaak.alfa.entity.Giphy;

@Component
public class GiphyService {
	
	@Value("${giphy.api_key}")
	private String api_key;
	
	@Value("${giphy.tag1}")
	private String tag1;
	
	@Value("${giphy.tag2}")
	private String tag2;
	
	@Value("${giphy.rating}")
	private String rating;
	
	@Autowired
	private GiphyClient giphyClient;
	
	public Giphy rich() {
		return giphyClient.getGiphy(api_key, tag1, rating);
	}
	
	public Giphy broke() {
		return giphyClient.getGiphy(api_key, tag2, rating);
	}
}
