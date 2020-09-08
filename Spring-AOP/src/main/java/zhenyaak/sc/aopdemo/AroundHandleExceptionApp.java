package zhenyaak.sc.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhenyaak.sc.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionApp {

	public static void main(String[] args) {
		Logger myLogger = Logger.getLogger(AroundHandleExceptionApp.class.getName());
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("--------AroundDemoApp executing:");
		myLogger.info("-------Calling getFortune()");
		boolean flag = true;
		String data = fortuneService.getFortune(flag);
		myLogger.info("\n----My Fortune is: " + data);
		myLogger.info("Finished");
		context.close();
	}
}
