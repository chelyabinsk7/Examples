package zhenyaak.sc.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhenyaak.sc.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerApp {

	public static void main(String[] args) {
		Logger myLogger= Logger.getLogger(AroundWithLoggerApp.class.getName());
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("AroundDemoApp executing:");
		myLogger.info("-------Calling getFortune()");
		String data = fortuneService.getFortune();
		myLogger.info("\n----My Fortune is: " + data);
		myLogger.info("Finished");
		context.close();
	}
}
