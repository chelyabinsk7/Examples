package ru.zhenyaak.alfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.zhenyaak.alfa.entity.ModelRequest;
import ru.zhenyaak.alfa.service.CurrencyService;
import ru.zhenyaak.alfa.service.GiphyService;

@Controller
public class AppController {
	
	@Value("${openexchangerates.convert_currency}")
	private String convert_currency;
	
	@Autowired
	private GiphyService giphyService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/endpoint")
	public String getEndpoint(@ModelAttribute("modelRequest") ModelRequest modelRequest, Model model) {
		modelRequest.setConvert_currency("RUB");
		model.addAttribute("giphy", giphyService.getGiphy(currencyService.currency(modelRequest.getConvert_currency())));
		model.addAttribute("text", giphyService.getComment(currencyService.currency(modelRequest.getConvert_currency()), modelRequest.getConvert_currency()));
		model.addAttribute("currency", currencyService.allCurrency());
		return "start.html";
	}
	
	@PostMapping("/endpoint")
	public String postEndpoint(@ModelAttribute("modelRequest") @Validated ModelRequest modelRequest, 
							BindingResult bindingResult, Model model){    
	    if (bindingResult.hasErrors()) {
	    	model.addAttribute("currency", currencyService.allCurrency());
	        return "start.html";	
	    }
		model.addAttribute("giphy", giphyService.getGiphy(currencyService.currency(modelRequest.getConvert_currency())));
		model.addAttribute("text", giphyService.getComment(currencyService.currency(modelRequest.getConvert_currency()), modelRequest.getConvert_currency()));
		model.addAttribute("currency", currencyService.allCurrency());
		return "start.html";
	}
	
}
