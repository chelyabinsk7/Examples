package ru.zhenyaak.alfa.controller.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

// Это правило не используется. Использовалось в другом варианте программы.
@Constraint(validatedBy = MyRuleValidator.class)
@Target ( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE} )
@Retention (RetentionPolicy.RUNTIME)
public @interface MyRule {
	public String message() default "Название валюты указано неверно или не указано. "
									+ "Пожалуйста, выберите валюту из списка";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default{};
}
