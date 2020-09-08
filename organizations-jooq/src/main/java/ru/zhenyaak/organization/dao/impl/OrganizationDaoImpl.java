package ru.zhenyaak.organization.dao.impl;

import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record4;
import org.jooq.codegen.maven.tables.Employee;
import org.jooq.codegen.maven.tables.Organization;
import org.jooq.codegen.maven.tables.records.OrganizationRecord;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static org.jooq.codegen.maven.Tables.*;
import ru.zhenyaak.organization.dao.OrganizationDao;


@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    @Autowired
    private DSLContext dsl;
    
	Organization O = ORGANIZATION.as("O");
	Organization O1 = ORGANIZATION.as("O1");
	Employee E = EMPLOYEE.as("E");

	public void create(String org_name, Long id_parent_long, int a) {
		if (a == 0) {
			dsl.insertInto(ORGANIZATION, O.ORG_NAME).
					values(org_name).
					execute();
		}
		else {
			dsl.insertInto(ORGANIZATION, O.ORG_NAME, O.ID_PARENT).
					values(org_name, (int)(long) id_parent_long).
					execute();	
		}
	}

	public void deleteOrganization(long id) {
		dsl.delete(O).
			where(O.ID.eq((int)id)).
			execute();
	}
	
	// Не используется
	public List<Record4<Integer, String, String, Integer>> getAllOrganization() {
		List<Record4<Integer, String, String, Integer>> result = 
				dsl.select(O.ID, O.ORG_NAME, O1.ORG_NAME.as("parent"), DSL.count(E.ID)).
				from(O).
				leftJoin(O1).on(O1.ID.eq(O.ID_PARENT)).
				leftJoin(E).on(E.ID_ORG.eq(O.ID)).
				groupBy(O.ID, O1.ORG_NAME).
				orderBy(O.ID).
				fetch();
		System.out.println(result);
		System.out.println("++++++++++++++++");
		return result;
	}
	
	public List<Record4<Integer, String, String, Integer>> findOrganization(String org_name) {
		List<Record4<Integer, String, String, Integer>> result = 
				dsl.select(O.ID, O.ORG_NAME, O1.ORG_NAME.as("parent"), DSL.count(E.ID)).
				from(O).
				leftJoin(O1).on(O1.ID.eq(O.ID_PARENT)).
				leftJoin(E).on(E.ID_ORG.eq(O.ID)).
				where(O.ORG_NAME.likeIgnoreCase("%" + org_name + "%")).
				groupBy(O.ID, O1.ORG_NAME).
				orderBy(O.ID).
				limit(100).
				fetch();
		return result;
	}
	
	public OrganizationRecord findOrganizationById(long id) {
		Record result = dsl.select().
						from(O).
						where(O.ID.eq((int) id)).
						fetchOne();
		OrganizationRecord org = new OrganizationRecord();
		org.setId((Integer) result.getValue(0));
		org.setOrgName((String) result.getValue(1));
		org.setIdParent((Integer) result.getValue(2));
		return org;
	}

	public void editOrganization(OrganizationRecord organization, int a) {
		if (a == 0) {
			dsl.update(ORGANIZATION).
			set(ORGANIZATION.ORG_NAME, organization.getOrgName()).
			where(ORGANIZATION.ID.eq(organization.getId())).
			execute();
		}
		else {
			dsl.update(ORGANIZATION).
			set(ORGANIZATION.ORG_NAME, organization.getOrgName()).
			set(ORGANIZATION.ID_PARENT, organization.getIdParent()).
			where(ORGANIZATION.ID.eq(organization.getId())).
			execute();
		}
	}
	
	public long getTotalNumberOrganization() {
		long total = dsl.select(DSL.count()).
						from(ORGANIZATION).
						fetchOne(0, long.class);
		return total;
	}

	public List<Record4<Integer, String, String, Integer>> getOrganizationPage(int page, int totals) {
		int for_offset = totals * (page - 1);
		List<Record4<Integer, String, String, Integer>> result = 
				dsl.select(O.ID, O.ORG_NAME, O1.ORG_NAME.as("parent"), DSL.count(E.ID)).
				from(O).
				leftJoin(O1).on(O1.ID.eq(O.ID_PARENT)).
				leftJoin(E).on(E.ID_ORG.eq(O.ID)).
				groupBy(O.ID, O1.ORG_NAME).
				orderBy(O.ID).
				limit(totals).
				offset(for_offset).
				fetch();
		return result;
	}
}
