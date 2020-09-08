package zhenyaak.sc.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhenyaak.sc.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("AroundDemoApp executing:");
		System.out.println("-------Calling getFortune()");
		String data = fortuneService.getFortune();
		System.out.println("\n----My Fortune is: " + data);
		System.out.println("Finished");
		context.close();
	}
}
