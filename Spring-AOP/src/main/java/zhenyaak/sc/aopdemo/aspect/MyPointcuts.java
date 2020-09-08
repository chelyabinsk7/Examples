package zhenyaak.sc.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyPointcuts {
	
	// Pointcut for all methods in package DAO
	@Pointcut("execution(* zhenyaak.sc.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// Pointcut for getter methods
	@Pointcut("execution(* zhenyaak.sc.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// Pointcut for setter methods
	@Pointcut("execution(* zhenyaak.sc.aopdemo.dao.*.set*(..))")
	public void setter() {}

	// Combine pointcuts (with dao and without getters/setters)
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
