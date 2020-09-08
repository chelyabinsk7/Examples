package ru.zhenyaak.organization.service.impl;

import java.util.List;

import org.jooq.Record4;
import org.jooq.codegen.maven.tables.records.OrganizationRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zhenyaak.organization.dao.impl.OrganizationDaoImpl;
import ru.zhenyaak.organization.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDaoImpl orgDao;

	public List<Record4<Integer, String, String, Integer>> getAllOrganization() {
		List<Record4<Integer, String, String, Integer>> result = orgDao.getAllOrganization();
		return result;
	}

	public OrganizationRecord findOrganizationById(long id) {
		OrganizationRecord organization = orgDao.findOrganizationById(id);
		return organization;
	}

	public void deleteOrganization(long id) {
		orgDao.deleteOrganization(id);
	}

	public void create(String org_name, Long id_parent_long, int a) {
		orgDao.create(org_name, id_parent_long, a);
	}

	public List<Record4<Integer, String, String, Integer>> getOrganizationPage(int page, int totals) {
		List<Record4<Integer, String, String, Integer>> organization = orgDao.getOrganizationPage(page, totals);
		return organization;
	}

	public long getTotalNumberOrganization() {
		long totalNumberOrganization = orgDao.getTotalNumberOrganization();
		return totalNumberOrganization;
	}

	public void editOrganization(OrganizationRecord organization, int a) {
		orgDao.editOrganization(organization, a);
	}

	public List<Record4<Integer, String, String, Integer>> findOrganization(String org_name) {
		List<Record4<Integer, String, String, Integer>> organization = orgDao.findOrganization(org_name);
		return organization;
	}	
}
