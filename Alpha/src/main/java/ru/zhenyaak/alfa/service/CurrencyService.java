package ru.zhenyaak.alfa.service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.zhenyaak.alfa.client.CurrencyClient;
import ru.zhenyaak.alfa.entity.Currency;

@Component
public class CurrencyService {
	
	@Value("${openexchangerates.app_id}")
	private String app_id;
	
	@Value("${openexchangerates.base_currency}")
	private String base_currency;
	
	private LocalDate date_today = LocalDate.now(ZoneOffset.UTC);
	private LocalDate date_yesterday = date_today.minusDays(1);
	
	@Autowired
	private CurrencyClient currencyClient;
	
	public int currency(String convert_currency){
		List <Currency> list = new ArrayList<>();
		list.add(currencyClient.getCurrency(date_today.toString(), app_id, convert_currency, base_currency));
		list.add(currencyClient.getCurrency(date_yesterday.toString(), app_id, convert_currency, base_currency));
		Double course_current = list.get(0).getRates().get(convert_currency);
		Double course_old = list.get(1).getRates().get(convert_currency);
		return compare(course_current, course_old);
	}
	
	public int compare(Double o1, Double o2) {
		if (o1 > o2) { return 1; }
		else if (o1 < o2) { return -1; } 
		else { return 0; }
	}
	
	public List<String> allCurrency(){
		List <String> list = new ArrayList<>();
		for(Map.Entry<String, Double> entry1 : currencyClient.getAllCurrency(date_today.toString(), app_id, base_currency).getRates().entrySet()) {
			list.add(entry1.getKey().toString());
		}
		return list;
	}
	
}
