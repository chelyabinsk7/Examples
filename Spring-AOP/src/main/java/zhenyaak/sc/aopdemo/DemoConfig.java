package zhenyaak.sc.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Конфигурационный файл
@EnableAspectJAutoProxy // Автоматическое включение прокси
@ComponentScan("zhenyaak.sc.aopdemo")
public class DemoConfig {

}
