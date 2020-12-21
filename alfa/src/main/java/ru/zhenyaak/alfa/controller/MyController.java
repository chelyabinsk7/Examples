package ru.zhenyaak.alfa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.zhenyaak.alfa.entity.Currency;
import ru.zhenyaak.alfa.service.CurrencyService;
import ru.zhenyaak.alfa.service.GiphyService;

@Controller
public class MyController {
	
	@Value("${openexchangerates.convert_currency}")
	private String convert_currency;
	
	@Autowired
	private GiphyService giphyService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		
		List <Currency> list = currencyService.currency();
		Double course_current = list.get(0).getRates().get(convert_currency);
		Double course_old = list.get(1).getRates().get(convert_currency);
		
		if (course_current > course_old) {
			Object giphy = giphyService.rich().getData().get("image_url");
			model.addAttribute("giphy", giphy);
			model.addAttribute("text", new String("Ура! Курс доллара к рублю вырос"));
			return "start.html";
		}
		
		if (course_current < course_old) {
			Object giphy = giphyService.broke().getData().get("image_url");
			model.addAttribute("giphy", giphy);
			model.addAttribute("text", new String("Курс доллара к рублю упал =("));
			return "start.html";
		}
		model.addAttribute("text", new String("Курс валют за сутки не изменился, гифок не будет."));
		return "start.html";
	}
	
	@GetMapping("/hello")
	public @ResponseBody String getHello() {
		return "Hello, world";
	}
}
