package ru.zhenyaak.alfa.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import ru.zhenyaak.alfa.service.CurrencyService;

@Component
public class MyRuleValidator implements ConstraintValidator <MyRule, String> {

	private CurrencyService currencyService;
	
	public MyRuleValidator(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

    public void initialize(MyRule constraintAnnotation) {
    	
    }

	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		boolean result;
		if (theCode != null) {
			result = currencyService.allCurrency().contains(theCode);
		}
		else {
			result = false;
		}
		return result;
	}
	
}
