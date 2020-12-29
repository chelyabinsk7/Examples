package ru.zhenyaak.alfa.entity;

import lombok.Getter;
import lombok.Setter;
import ru.zhenyaak.alfa.controller.validation.MyRule;

public class ModelRequest {
    
	@MyRule
	@Getter @Setter
    private String convert_currency;

}
