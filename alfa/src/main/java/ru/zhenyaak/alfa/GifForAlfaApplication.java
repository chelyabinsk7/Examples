package ru.zhenyaak.alfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class GifForAlfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifForAlfaApplication.class, args);
		System.out.println("=======");
	}

}
