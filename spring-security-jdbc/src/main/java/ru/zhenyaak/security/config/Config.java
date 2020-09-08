package ru.zhenyaak.security.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="ru.zhenyaak.security")
@PropertySource("classpath:persistence-mysql.properties")
public class Config {

	// Переменная для хранения данных из properties-файла
	@Autowired
	private Environment env; 
	
	// Логгер для диагностики при выполнении
	private Logger logger = Logger.getLogger(getClass().getName());
		
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// Bean для security datasource
	@Bean
	public DataSource securityDataSource() {
		
		// Создание пула соединений
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		// установка jdbc-драйвера
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// Логирование свойств соединения
		logger.info("-------jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("-------jdbc.user=" + env.getProperty("jdbc.user"));
		
		// Параметры подключения к БД
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// settings connection pool
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
	
		return securityDataSource;
	}
	
	// Вспомогательный метод, конвертирующий в число
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
}
