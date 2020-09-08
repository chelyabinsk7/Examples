package ru.zhenyaak.organization.service;

import java.util.List;

import org.jooq.Record4;
import org.jooq.codegen.maven.tables.records.OrganizationRecord;

public interface OrganizationService {
	List<Record4<Integer, String, String, Integer>> getAllOrganization(); // Вывод всех строк
	OrganizationRecord findOrganizationById(long id);
	void deleteOrganization(long id);
	void create(String org_name, Long id_parent_long, int a);
	List<Record4<Integer, String, String, Integer>> getOrganizationPage(int page, int totals);
	long getTotalNumberOrganization();
	void editOrganization(OrganizationRecord organization, int a);
	List<Record4<Integer, String, String, Integer>> findOrganization(String org_name);
}
