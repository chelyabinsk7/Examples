package ru.zhenyaak.alfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ru.zhenyaak.alfa.service.CurrencyService;

@SpringBootApplication
@EnableFeignClients
public class GifForAlfaApplication {

	@Autowired
	CurrencyService currencyService;
	
	public static void main(String[] args) {
		SpringApplication.run(GifForAlfaApplication.class, args);
		System.out.println("=======");
	}

}
