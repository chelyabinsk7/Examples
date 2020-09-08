package ru.zhenyaak.organization.dao.impl;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record4;
import org.jooq.codegen.maven.tables.Employee;
import org.jooq.codegen.maven.tables.Organization;
import org.jooq.codegen.maven.tables.records.EmployeeRecord;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.zhenyaak.organization.dao.EmployeeDao;
import ru.zhenyaak.organization.exception.EmployeeException;
import static org.jooq.codegen.maven.Tables.*;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
    @Autowired
    private DSLContext dsl;
    
	Organization O = ORGANIZATION.as("O");
	Employee E = EMPLOYEE.as("E");
	Employee E1 = EMPLOYEE.as("E1");

	public List<Record4<Integer, String, String, String>> getEmployee(int total) {
		List<Record4<Integer, String, String, String>> result = 
				dsl.select(E.ID, E.EMP_NAME, E1.EMP_NAME.as("head"), O.ORG_NAME.as("org")).
				from(E).
				leftJoin(E1).on(E1.ID.eq(E.ID_HEAD)).
				leftJoin(O).on(E.ID_ORG.eq(O.ID)).
				orderBy(E.ID).
				limit(total).
				fetch();
		return result;
	}

	public void create(String emp_name, String id_org, Long id_head_long, int a) throws EmployeeException{
		if (a == 0 ) {
			dsl.insertInto(EMPLOYEE, E.EMP_NAME, E.ID_ORG).
			values(emp_name, (int) Long.parseLong(id_org)).
			execute();	
		}
		else {
			Long k = dsl.select(E.ID_ORG).
					   from(E).
					   where(E.ID.eq((int)(long)id_head_long)).
					   fetchOne(0, long.class);
			if (k == Long.parseLong(id_org)) { // Проверка принадлежности руководителя к организации
				dsl.insertInto(EMPLOYEE, E.EMP_NAME, E.ID_ORG, E.ID_HEAD).
				values(emp_name, (int) Long.parseLong(id_org), (int)(long)id_head_long).
				execute();	
			}
			else {
				throw new EmployeeException("The head is not in the same organization");
			}
		}
	}

	
	public EmployeeRecord findEmployeeById(long id) {		
		Record result = dsl.select().from(E).
							where(E.ID.eq((int) id)).
							fetchOne();
		EmployeeRecord emp = new EmployeeRecord();
		emp.setId((Integer) result.getValue(0));
		emp.setEmpName((String) result.getValue(1));
		emp.setIdOrg((Integer) result.getValue(2));
		emp.setIdHead((Integer) result.getValue(3));
		return emp;
	}

	public void editEmployee(EmployeeRecord employee, int a) throws EmployeeException {
		long total_subject = dsl.select(DSL.count()). // Количество людей в подчинении
							   from(E).
							   where(E.ID_HEAD.eq(employee.getId())).
							   fetchOne(0, long.class);
		int id_org = dsl.select(E.ID_ORG). // Организация до внесения изменений
						from(E).
						where(E.ID.eq(employee.getId())).
						fetchOne(0, int.class);
		long org_head = dsl.select(EMPLOYEE.ID_ORG). // Для проверки принадлежности руководителя к организации 
					from(EMPLOYEE).
					where(EMPLOYEE.ID.eq(employee.getIdHead())).
					fetchOne(0, long.class);
		if (a == 0) { // Если нет руководителя
			if (total_subject == 0) { // Если нет подчинённых
				dsl.update(EMPLOYEE).
				set(EMPLOYEE.EMP_NAME, employee.getEmpName()).
				set(EMPLOYEE.ID_ORG, employee.getIdOrg()).
				set(EMPLOYEE.ID_HEAD, employee.getIdHead()).
				where(EMPLOYEE.ID.eq(employee.getId())).
				execute();
			}
			else {
				if (id_org == employee.getIdOrg()){ // Нельзя менять организацию, имея подчинённых
					dsl.update(EMPLOYEE).
					set(EMPLOYEE.EMP_NAME, employee.getEmpName()).
					set(EMPLOYEE.ID_HEAD, employee.getIdHead()).
					where(EMPLOYEE.ID.eq(employee.getId())).
					execute();
				}
				else {
					throw new EmployeeException("This is someone's head. He cannot change organization");
				}

			}
		}
		else {
			if (org_head == employee.getIdOrg()){ // Проверка, что руководитель из той же организации
				if (employee.getId() != employee.getIdHead()) { // Проверка, чтоб не руководил сам собой
					if (total_subject == 0) { // Если нет подчинённых
						dsl.update(EMPLOYEE).
						set(EMPLOYEE.EMP_NAME, employee.getEmpName()).
						set(EMPLOYEE.ID_ORG, employee.getIdOrg()).
						set(EMPLOYEE.ID_HEAD, employee.getIdHead()).
						where(EMPLOYEE.ID.eq(employee.getId())).
						execute();
					}
					else {
						if (id_org == employee.getIdOrg()){ // Нельзя менять организацию, имея подчинённых
							dsl.update(EMPLOYEE).
							set(EMPLOYEE.EMP_NAME, employee.getEmpName()).
							set(EMPLOYEE.ID_HEAD, employee.getIdHead()).
							where(EMPLOYEE.ID.eq(employee.getId())).
							execute();
						}
						else {
							throw new EmployeeException("This is someone's head. He cannot change organization");
						}

					}
				}
				else {
					throw new EmployeeException("Employee cannot lead himself");
				}
			}
			else {
				throw new EmployeeException("Head from another organization");
			}
		}
	}

	public void deleteEmployee(long id) {
		dsl.delete(E).
		where(E.ID.eq((int)id)).
		execute();
	}

	public List<Record4<Integer, String, String, String>> findEmployee(String emp_name, String org_name) {		
		List<Record4<Integer, String, String, String>> result = 
				dsl.select(E.ID, E.EMP_NAME, E1.EMP_NAME.as("head"), O.ORG_NAME.as("org")).
				from(E).
				leftJoin(E1).on(E1.ID.eq(E.ID_HEAD)).
				leftJoin(O).on(E.ID_ORG.eq(O.ID)).
				where(E.EMP_NAME.likeIgnoreCase("%" + emp_name + "%").
						and(O.ORG_NAME.likeIgnoreCase("%" + org_name + "%"))).
				orderBy(E.ID).
				limit(100).
				fetch();
		return result;
	}
}
