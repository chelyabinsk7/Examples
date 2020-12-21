package ru.zhenyaak.alfa.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.zhenyaak.alfa.entity.Currency;

@RunWith(SpringRunner.class)
@SpringBootTest
class CurrencyServiceTest {

	@Autowired
	private CurrencyService currencyService;
	
	List <Currency> list = new ArrayList<>();
	
	@Test
	void testCurrency() {
		Assertions.assertFalse(currencyService.currency().isEmpty());
	}

}
