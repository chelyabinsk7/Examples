package ru.zhenyaak.organization.service;

import java.util.List;

import org.jooq.Record4;
import org.jooq.codegen.maven.tables.records.EmployeeRecord;

import ru.zhenyaak.organization.exception.EmployeeException;

public interface EmployeeService {
	List<Record4<Integer, String, String, String>> getEmployee(int total);
	void deleteEmployee(long id);
	void create(String emp_name, String id_org, Long id_head_long, int a) throws EmployeeException;
	void editEmployee(EmployeeRecord employee, int a) throws EmployeeException;
	List<Record4<Integer, String, String, String>> findEmployee(String emp_name, String org_name);
	EmployeeRecord findEmployeeById(long id);
}
