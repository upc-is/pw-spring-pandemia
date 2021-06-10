package pe.edu.upc.pandemia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.service.crud.RegionService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private RegionService regionService;
	
	@GetMapping("regions")
	public String searchRegionGet(Model model, @ModelAttribute("regionSearch") Region regionSearch) {
		System.out.println(regionSearch.getName());
		try {
			List<Region> regionsFound = regionService.findByNameStartingWith(regionSearch.getName());
			model.addAttribute("regionsFound", regionsFound);
			model.addAttribute("regionSearch", regionSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/regions-result";
	}

}
