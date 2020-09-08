package zhenyaak.sc.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {
	
	@Before("zhenyaak.sc.aopdemo.aspect.MyPointcuts.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n===== performing API Analytics()");
	}
}
