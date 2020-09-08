package ru.zhenyaak.organization.controller;

import java.util.List;
import org.jooq.Record4;
import org.jooq.codegen.maven.tables.records.OrganizationRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zhenyaak.organization.service.impl.OrganizationServiceImpl;

@Controller
public class OrganizationController {

	@Autowired
	private OrganizationServiceImpl orgService;
	
	@GetMapping("/")
	private String index() {
		return "redirect:/organization/1";
	}
	
	// Не используется
//	@GetMapping("/organization")
//	private String getAllOrganizations(Model model) {   
//		List<Record4<Integer, String, String, Integer>> organization = orgService.getAllOrganization();
//		model.addAttribute("organization_list", organization);
//		return "organization/organization_list";
//	}
	
    @GetMapping("/org_add")
    public String add() {
        return "organization/org_addForm";
    }
	
	@PostMapping("/add1")
    private String add(String org_name, String id_parent){
		int a;
		Long id_parent_long;
		if (id_parent == "") {
			a = 0; // Индикатор, что нет родительской компании
			id_parent_long = null;
		}
		else {
			a = 1;
			id_parent_long = Long.parseLong(id_parent);
		}
		orgService.create(org_name, id_parent_long, a);
        return "redirect:/organization/1";
    }

    @GetMapping("/org_delete")
    private String organizationDelete(@RequestParam("id") long id){
    	orgService.deleteOrganization(id);
        return "redirect:/organization/1";
    }
    
	@PostMapping("/org_search")
    private String search(Model model, String org_name){
		List<Record4<Integer, String, String, Integer>> organization = orgService.findOrganization(org_name);
		model.addAttribute("organization_pagelist", organization);
		return "organization/organization_list";
    }
	
    @GetMapping("/org_edit/{id}")    
    private String edit(@ModelAttribute("command") @PathVariable long id, Model model){    
    	OrganizationRecord organization = orgService.findOrganizationById(id); 
        model.addAttribute("command", organization);  
        return "organization/org_editForm";    
    }  
    
    @PostMapping("/org_editsave")
    private String editsave(OrganizationRecord organization, String id_parent){ 
    	int a;
		if (id_parent == "") {
			a = 0; // Индикатор, что не будет родительской компании
		}
		else {
			a = 1;
		}  
		orgService.editOrganization(organization, a);
        return "redirect:/organization/1";    
    }  
    
	@GetMapping("/organization/{page}")
	private String getAllOrganizationsPage(@PathVariable int page, Model model) {
        int totals = 5; // Организаций на странице
        long total_page; // Всего страниц
        if (orgService.getTotalNumberOrganization() % totals == 0) {
        	total_page = orgService.getTotalNumberOrganization() / totals;
        }
        else {
        	total_page = orgService.getTotalNumberOrganization() / totals + 1;
        }
		List<Record4<Integer, String, String, Integer>> organization = orgService.getOrganizationPage(page, totals);
		model.addAttribute("organization_pagelist", organization);
    	model.addAttribute("total_page", total_page); // Кол-во отображаемых страниц внизу списка
		return "organization/organization_list";
	}
}
