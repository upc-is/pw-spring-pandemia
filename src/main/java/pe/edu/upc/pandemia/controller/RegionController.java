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

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.service.crud.RegionService;

@Controller
@RequestMapping("/regions")
@SessionAttributes("regionEdit")  // Se utiliza para guardar el objeto en memoria, cuando se envia y retorna.
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
				return "regions/view"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/regions";	// url
	}
	
	@GetMapping("{id}/edit")		// GET: /regions/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Region> optional = regionService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("regionEdit", optional.get());
				return "regions/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/regions";	// url
	}
	
	@PostMapping("save")	// GET: /regions/save
	public String saveEdit(Model model, @ModelAttribute("regionEdit") Region region) {
		try {
			Region regionReturn = regionService.update(region);
			model.addAttribute("region", regionReturn);
			return "regions/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/regions";
	}
	
	@GetMapping("new")		// GET: /regions/{id}/edit
	public String newItem(Model model) {
		try {
			Region region = new Region();
			model.addAttribute("regionNew", region);
			return "regions/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/regions";	// url
	}
	
	@PostMapping("savenew")	// GET: /regions/savenew
	public String saveNew(Model model, @ModelAttribute("regionNew") Region region) {
		try {
			Region regionReturn = regionService.create(region);
			model.addAttribute("region", regionReturn);
			return "regions/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/regions";
	}
	
	
	
}
