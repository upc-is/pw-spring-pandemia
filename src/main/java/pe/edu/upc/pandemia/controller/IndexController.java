package pe.edu.upc.pandemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Region;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String indexGet(Model model ) {
		Region regionSearch = new Region();
		model.addAttribute("regionSearch", regionSearch);
		return "index";
	}
}
