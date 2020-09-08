package zhenyaak.sc.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import zhenyaak.sc.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean flag){
		if (flag) {
			throw new RuntimeException("+_+_+_+_+_+_+_+_+_+_+_+_+");
		}
		
		List<Account> accounts = new ArrayList<>();
		Account account1 = new Account ("Stan", "Admin");
		Account account2 = new Account ("Kyle", "Moderator");
		Account account3 = new Account ("Kenny", "User");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}
	
	public void addAccount(Account account, boolean bool) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
} 
