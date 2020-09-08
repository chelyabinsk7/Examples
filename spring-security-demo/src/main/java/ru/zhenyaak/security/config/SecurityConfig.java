package ru.zhenyaak.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override // Source -- Override method
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Добавление пользователей
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("John").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("Mary").password("test123").roles("EMPLOYEE", "MANAGER"))
		.withUser(users.username("Ivan").password("test123").roles("EMPLOYEE", "ADMIN"));
	
	}

	@Override
// То, что закомментированно. Любой запрос (anyRequest) требует авторизации. 
// Ссылка на страницу (LoginPage) и обработчик. Доступно всем (permitAll).
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.anyRequest().authenticated() // Ограничение для всех 
			.antMatchers("/").hasRole("EMPLOYEE") // Доступно только сотрудникам
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll() // Возможность разлогиниться для всех
			.and()
			.exceptionHandling() // Страница с ошибкой при нехватке прав доступа
			.accessDeniedPage("/access-denied");
	}
}
