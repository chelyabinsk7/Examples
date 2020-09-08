package ru.zhenyaak.security.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	// for leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	// for admins
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
