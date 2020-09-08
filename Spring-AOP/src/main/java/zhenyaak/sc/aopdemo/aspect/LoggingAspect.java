package zhenyaak.sc.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import zhenyaak.sc.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* zhenyaak.sc.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("-------Executing @Around on method: " + method);
		long begin = System.currentTimeMillis();
		
		// Изначальная позиция
		Object result = null;
		try { // Если метод getFortune() выполнится
			result = proceedingJoinPoint.proceed(); 
		} catch (Exception e) { // Если возникнет исключение
			// Вывод сообщения об ошибке (throw new RuntimeException("------EXCEPTION!!!!")
			myLogger.warning(e.getMessage());
			
			// Далее возможны два варианта
			// 1) Возврат этой строки вместо return getFortune(); при исключении
//			result = "---------EXCEPTION IN LoggingAspect";
			
			// Выброс ошибок
			throw e;
		}
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("\n---------Duration: " + duration / 1000.0 + " seconds");
		return result;
	}
	
	
	@After("execution(* zhenyaak.sc.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("===Executing @After on method: " + method);
	}
	
	@AfterThrowing (
			pointcut="execution(* zhenyaak.sc.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint joinPoint, Throwable theExc) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("===Executing @AfterThrowing on method: " + method);
		myLogger.info("===The exception is: " + theExc);
		
	}
	
	@AfterReturning(
			pointcut="execution(* zhenyaak.sc.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccounts(
			JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("===Executing @AfterRetirning on method: " + method);
		myLogger.info("===Result is: " + result);
	
		// Модификация возвращаемых данных
		convertAccountNamesToUpperCase(result);
	}
	
	// Все имена станут заглаными буквами
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
	}

	@Before("zhenyaak.sc.aopdemo.aspect.MyPointcuts.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		myLogger.info("\n===== Executing @Before advice on addAccount()");
		// Показать название метода (с  параметрами)
		MethodSignature metSig = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method: " + metSig);
		
		// Показать значения аргументов метода
		Object[] args = joinPoint.getArgs();
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			// Для аккаунта сперва отобразится его хэш-код
			// А ниже - подробности
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				myLogger.info("Account name: " + account.getName());
				myLogger.info("Account level: " + account.getLevel());
			}
		}
	}
}
