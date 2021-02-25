package ru.zhenyaak.alfa.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GiphyServiceTest {

	@Autowired
	private GiphyService giphyService;
	
	@Test
	// Проверка типа возвращаемого объекта при запросе гифки
	void getGiphyTest() {
		int compare = -1;
		Object object = giphyService.getGiphy(compare);
		Assertions.assertTrue(object instanceof String);
		compare = 1;
		object = giphyService.getGiphy(compare);
		Assertions.assertTrue(object instanceof String);
		compare = 0;
		object = giphyService.getGiphy(compare);
		Assertions.assertFalse(object instanceof String);
	}
	
	@Test
	// Проверка возвращаемого комментария
	void getCommentTest() {
		int compare = 0;
		String convert_currency = "USD";
		String actual = "Курс USD к " + convert_currency + " за сутки не изменился, гифок не будет.";
		String expected = giphyService.getComment(compare, convert_currency);
		Assertions.assertEquals(expected, actual);
	}
}
