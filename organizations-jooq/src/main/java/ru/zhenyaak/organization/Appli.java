package ru.zhenyaak.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (
		scanBasePackages={"ru.zhenyaak.organization.controller", 
				"ru.zhenyaak.organization.dao.impl", 
				"ru.zhenyaak.organization.service.impl"})
public class Appli {    
	
	public static void main(String[] args) {
		SpringApplication.run (Appli.class, args);
		System.out.println("***************");
	}
}
