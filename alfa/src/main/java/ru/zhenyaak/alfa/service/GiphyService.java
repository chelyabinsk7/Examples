package ru.zhenyaak.alfa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.zhenyaak.alfa.client.GiphyClient;

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
	
	public Object getGiphy(int compare) {
		if (compare == 1)
			return giphyClient.getGiphy(api_key, tag1, rating).getData().get("image_url");
		else if (compare == -1)
			return giphyClient.getGiphy(api_key, tag2, rating).getData().get("image_url");
		else 
			return null;
	}
	
	public String getComment(int compare, String convert_currency) {
		if (compare == 1)
			return "Ура! Курс USD к " + convert_currency + " за сутки вырос";
		else if (compare == -1)
			return "Курс USD к " + convert_currency + " за сутки снизился =(";
		else 
			return "Курс USD к " + convert_currency + " за сутки не изменился, гифок не будет.";
	}
}
