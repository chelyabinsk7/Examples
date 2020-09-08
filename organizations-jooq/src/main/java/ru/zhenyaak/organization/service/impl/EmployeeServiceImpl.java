package ru.zhenyaak.organization.service.impl;

import java.util.List;
import org.jooq.Record4;
import org.jooq.codegen.maven.tables.records.EmployeeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zhenyaak.organization.dao.impl.EmployeeDaoImpl;
import ru.zhenyaak.organization.exception.EmployeeException;
import ru.zhenyaak.organization.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDaoImpl empDao;

	public List<Record4<Integer, String, String, String>> getEmployee(int total) {
		List<Record4<Integer, String, String, String>> employee = empDao.getEmployee(total);
		return employee;
	}

	public void deleteEmployee(long id) {
		empDao.deleteEmployee(id);
	}

	public void create(String emp_name, String id_org, Long id_head_long, int a) throws EmployeeException {
		empDao.create(emp_name, id_org, id_head_long, a);		
	}

	public void editEmployee(EmployeeRecord employee, int a) throws EmployeeException {
		empDao.editEmployee(employee, a);
	}

	public List<Record4<Integer, String, String, String>> findEmployee(String emp_name, String org_name) {
		List<Record4<Integer, String, String, String>> employee = empDao.findEmployee(emp_name, org_name);
		return employee;
	}

	public EmployeeRecord findEmployeeById(long id) {
		EmployeeRecord employee = empDao.findEmployeeById(id);
		return employee;
	}
}
