package zhenyaak.sc.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhenyaak.sc.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		try {
			// При true вылезет исключение (см. AccountDAO)
			boolean flag = false;
			accounts = accountDAO.findAccounts(flag);
		}
		catch (Exception exc) {
			System.out.println("\n=====Caught exception: " + exc);
		}
		System.out.println(accounts);
		context.close();
	}
}
