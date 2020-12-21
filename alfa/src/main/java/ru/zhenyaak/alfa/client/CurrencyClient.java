package ru.zhenyaak.alfa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ru.zhenyaak.alfa.entity.Currency;

@FeignClient(url = "https://openexchangerates.org/historical", name = "CURRENCY-CLIENT")
public interface CurrencyClient {
	
	
    @GetMapping("/{date}.json?app_id={app_id}&symbols={convert_currency}&base={base_currency}")
    public Currency getCurrency(@PathVariable("date") String date, 
					    		@PathVariable("app_id") String app_id,
					    		@PathVariable("convert_currency") String convert_currency,
					    		@PathVariable("base_currency") String base_currency);
}
