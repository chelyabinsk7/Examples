package ru.zhenyaak.organization.controller;

import java.util.List;

import org.jooq.Record4;
import org.jooq.codegen.maven.tables.records.EmployeeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zhenyaak.organization.exception.EmployeeException;
import ru.zhenyaak.organization.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empService;
	
	public int total_global = 15; // Добавляется записей за одно нажатие "Show more"
	public int total = 15; // Начальное число показываемых записей
	
    @GetMapping("/employee1")
    public String show15() {
    	// Сброс счётчика, если перейти по ссылке
		total = 0;
        return "redirect:/employee";
    }
    
	@GetMapping("/employee")
	private String getAllEmployee(Model model) {
		if (total == 0 ) {
			total = 15;
		}
		List<Record4<Integer, String, String, String>> employee = empService.getEmployee(total);
		model.addAttribute("employee_list", employee);
		model.addAttribute("total", total);
		return "employee/employee_list";
	}
    
    @GetMapping("/show_more")
    public String showMore() {
		total = total + total_global;
        return "redirect:/employee";
    }
    
    @GetMapping("/emp_add")
    public String add() {
        return "employee/emp_addForm";
    }
	
	@PostMapping("/add2")
    private String add(Model model, String emp_name, String id_org, String id_head) throws EmployeeException{
		int a;
		Long id_head_long;
		if (id_head == "") { // Обработчик пустой строки
			a = 0;
			id_head_long = null;
		}
		else {
			a = 1;
			id_head_long = Long.parseLong(id_head);
		}
		empService.create(emp_name, id_org, id_head_long, a);
		total = 0;
		model.addAttribute("total", total);
        return "redirect:/employee";
    }
	
    @GetMapping("emp_edit/{id}")    
    private String edit(@ModelAttribute("command") @PathVariable long id, Model model){    
    	EmployeeRecord employee = empService.findEmployeeById(id); 
        model.addAttribute("command", employee);
        return "employee/emp_editForm";    
    }  
    
    @PostMapping("/emp_editsave")
    private String editsave(EmployeeRecord employee, String IdHead) throws EmployeeException{ 
    	int a;
		if (IdHead == "") { // Обработчик пустой строки
			a = 0;
		}
		else {
			a = 1;
		}    
		empService.editEmployee(employee, a);
        return "redirect:/employee";    
    }
    
    @GetMapping("/employee_delete")
    private String employeeDelete(@RequestParam("id") long id, Model model){
    	empService.deleteEmployee(id);
		model.addAttribute("total", total);
        return "redirect:/employee";
    }
    
	@PostMapping("/emp_search")
    private String search(Model model, String emp_name, String org_name){
		List<Record4<Integer, String, String, String>> employee = empService.findEmployee(emp_name, org_name);
		total = 0;
    	model.addAttribute("total", total);
		model.addAttribute("employee_list", employee);
		return "employee/employee_list";
    }
}
