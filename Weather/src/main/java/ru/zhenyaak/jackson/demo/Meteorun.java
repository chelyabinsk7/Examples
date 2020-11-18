package ru.zhenyaak.jackson.demo;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Meteorun {
	
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		double temp_avg = 0; // Средняя температура
		int days = 5; // Количество дней
		double temp_max_temp; // Временное максимальное значение
		double temp_max = -1000; // Максимальное значение
		String url = "http://api.openweathermap.org/data/2.5/forecast?q=Perm,RU&units=metric&lang=ru"
				+ "&appid=6b74325bbdbcb41cf459dfb8ab8c4e75";

		try {
			
			List<Meteo> list = Arrays.asList(mapper.readValue(new URL(url), Meteo.class));
			
			for (Meteo x : list) {
				int timezone = x.getCity().getTimezone(); // Разница во времени
				List<Object> list1 = x.getList();
				
				for (Object x1 : list1) {
					String s1 = x1.getDt_txt(); // Получение времени
					Calendar calendar = Calendar.getInstance();
					
					try {
						calendar.setTime(sdf.parse(s1)); // Преобразование строки во время
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					calendar.add(Calendar.SECOND, timezone); // Правка часового пояса
					String time = sdf.format(calendar.getTime()).toString(); // Преобразование времени в строку
					
					// Поиск по маске утреннего времени (с 6:00 до 8:00)
					if (time.matches(".{11}(06|07|08).*")) {
						temp_avg = temp_avg + x1.getMain().getTemp();
						temp_max_temp = x1.getMain().getTemp();
						if (temp_max_temp > temp_max) {
							temp_max = temp_max_temp;
						}
					}
				}
				
				System.out.printf("Средняя температура утром на следующие %d дней составит %.2f \n", 
						  days,  temp_avg / days);
				System.out.printf("Утренний максимум на следующие %d дней составит %.2f", 
							  days,  temp_max);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
