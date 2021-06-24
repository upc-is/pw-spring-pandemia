package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.EmployeeLanguage;
import pe.edu.upc.pandemia.model.entity.Language;
import pe.edu.upc.pandemia.service.crud.EmployeeService;
import pe.edu.upc.pandemia.service.crud.LanguageService;

@Controller
@RequestMapping("/human-resource")
public class HumanResourceController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private LanguageService languageService;

	@GetMapping("employee/{id}")
	public String employeeInfoGet(Model model, @ModelAttribute("employeeSearch") Employee employeeSearch, 
			@PathVariable("id") Integer id) {
		try {
			Optional<Employee> optional = employeeService.findById(id);
			if(optional.isEmpty()) {
				return "redirect:/login";
			}			
			model.addAttribute("employee", optional.get());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		model.addAttribute("employeeSearch", employeeSearch);
		return "hr/employee-info";
	}
	
	@GetMapping("add-language/{id}")
	public String addlanguageGet(Model model, @ModelAttribute("employeeSearch") Employee employeeSearch, 
			@PathVariable("id") Integer id) {
		
		try {
			Language language = new Language();
			
			EmployeeLanguage employeeLanguage = new EmployeeLanguage();
			employeeLanguage.setId(id);
			employeeLanguage.setLanguage(language);
			
			List<Language> languages = languageService.getAll();			
			
			model.addAttribute("language", language);
			model.addAttribute("languages", languages);
			model.addAttribute("employeeLanguage", employeeLanguage);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		model.addAttribute("employeeSearch", employeeSearch);
		return "hr/add-language";
	}
	@PostMapping("save-language")
	public String savelanguagePost(Model model, @ModelAttribute("employeeSearch") Employee employeeSearch,
			 @ModelAttribute("employeeLanguage") EmployeeLanguage employeeLanguage) {
		
		System.out.println(employeeLanguage.getId());
		System.out.println(employeeLanguage.getLanguage().getId());
		System.out.println(employeeLanguage.getLanguage().getName());
		
		Optional<Employee> optional;
		try {
			optional = employeeService.findById(employeeLanguage.getId());
			if(optional.isEmpty()) {
				return "redirect:/login";
			}	
			optional.get().getLanguages().add(employeeLanguage.getLanguage());
			
			employeeLanguage.getLanguage().getEmployees().add(optional.get());
			
			employeeService.update(optional.get());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		model.addAttribute("employeeSearch", employeeSearch);
		return "redirect:/human-resource/employee/" + employeeLanguage.getId();
	}
}
