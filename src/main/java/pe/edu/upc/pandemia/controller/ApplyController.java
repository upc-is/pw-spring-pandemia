package pe.edu.upc.pandemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Employee;

@Controller
@RequestMapping("/apply")
public class ApplyController {
	
	@GetMapping("register")
	public String registerGet(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "";
	}

}
