package ru.zhenyaak.alfa.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyServiceTest {

	@Autowired
	private CurrencyService currencyService;
	
	@Test
	// Доллар по отношению к самому себе не изменится
	void currencyTest() {
		int wait_result = 0;
		int get_result = currencyService.currency("USD");
		Assertions.assertEquals(wait_result, get_result);
	}
	
	@Test
	 // Сравнение чисел
	void compareTest() {
		int wait_result = 1;
		int get_result = currencyService.compare(10.0, 0.0);
		Assertions.assertEquals(wait_result, get_result);
	}
	
	@Test
	// Полученный список валют не пустой
	void allCurrencyTest() {
		Assertions.assertFalse(currencyService.allCurrency().isEmpty());
	}

}
