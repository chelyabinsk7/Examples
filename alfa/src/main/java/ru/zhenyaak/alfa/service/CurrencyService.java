package ru.zhenyaak.alfa.service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
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
	
	@Value("${openexchangerates.convert_currency}")
	private String convert_currency;
	
	private LocalDate date_today = LocalDate.now(ZoneOffset.UTC);
	private LocalDate date_yesterday = date_today.minusDays(1);
	
	@Autowired
	private CurrencyClient currencyClient;
	
	public List<Currency> currency(){
		List <Currency> list = new ArrayList<>();
		list.add(currencyClient.getCurrency(date_today.toString(), app_id, convert_currency, base_currency));
		list.add(currencyClient.getCurrency(date_yesterday.toString(), app_id, convert_currency, base_currency));
		return list;
		
	}
}
