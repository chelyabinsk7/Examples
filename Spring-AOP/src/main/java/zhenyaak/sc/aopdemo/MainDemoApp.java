package zhenyaak.sc.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhenyaak.sc.aopdemo.dao.AccountDAO;
import zhenyaak.sc.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		Account account = new Account();
		account.setName("Steve");
		account.setLevel("Bruce");
		accountDAO.setName("sports");
		accountDAO.setServiceCode("foot");
		String name = accountDAO.getServiceCode();
		accountDAO.addAccount(account, false);
		membershipDAO.addAccount();
		context.close();
	}
}
