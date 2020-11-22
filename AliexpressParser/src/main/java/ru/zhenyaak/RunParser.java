package ru.zhenyaak;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;


/*
При открытии сайта, а также при скроллинге включается javaScript,
подгружающий товары в JSON-формате.

За исключением самих данных в формате JSON, при запуске скрипта каждый 
раз подгружается строка формата /##/jQuery18306038704632127208_1605987579407
Её приходится обрезать с помощью метода subString. Затем строка конвертируется
в объект с помощью Jackson. После чего происходит запись в файл Products.csv"

У некоторых товаров заданы не все характеристики. В этом случае пустое поле приобретает значение null.
 */
public class RunParser {
	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();
		ObjectMapper mapper = new ObjectMapper();
		String fileName = "Products.csv";
		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(file);
		String url;
		
		for (int offset = 0; offset < 100; offset += 10){
			url = "https://gpsfront.aliexpress.com/getRecommendingResults.do?widget_id=5547572&limit=10"
					+ "&offset=" + offset + "&postback=732db1c7-edf1-46d0-af03-64f78613fa78";

			URL obj = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
			    response.append(inputLine);
			}
			in.close();

			String s = response.toString(); // Получение тела GET-запроса
			String s1 = s.substring(s.lastIndexOf("{\"contextId\"")); // Обрезка лишнего
			Product p = mapper.readValue(s1, Product.class);
			
			List<Results> list1 = p.getResults();
			for (Results x1 : list1) {
				pw.println(x1);
			}
		}
		pw.close(); 
		
		long finishTime = System.currentTimeMillis();
		System.out.println("100 позиций были записаны в файл " + fileName);
		System.out.println("Время выполнения программы: " + ((finishTime - startTime)/1000) + " секунд");	
	}
}