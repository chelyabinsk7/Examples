package zhenyaak.sc.aopdemo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------hello  from getFortune before return");
		return "----------Execute getFortune with false";
	}

	public String getFortune(boolean flag) {
		if (flag) {
			throw new RuntimeException("------EXCEPTION!!!!");
		}
		return getFortune();
	}
}
