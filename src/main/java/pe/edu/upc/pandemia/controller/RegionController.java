package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.service.crud.RegionService;

@Controller
@RequestMapping("/regions")
public class RegionController {

	@Autowired
	private RegionService regionService;
	
	@GetMapping		// GET: /regions
	public String listar( Model model ) {
		try {
			List<Region> regions = regionService.getAll();
			model.addAttribute("regions", regions);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "regions/lista";
	}
	
	@GetMapping("{id}")		// GET: /regions/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Region> optional = regionService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("region", optional.get());
				return "regions/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "";
	}
	
}
