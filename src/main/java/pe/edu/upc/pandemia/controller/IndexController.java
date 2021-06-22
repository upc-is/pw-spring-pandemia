package pe.edu.upc.pandemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.Region;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String indexGet(Model model ) {
		Region regionSearch = new Region();
		Employee employeeSearch = new Employee();
		model.addAttribute("regionSearch", regionSearch);
		model.addAttribute("employeeSearch", employeeSearch);
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
}
