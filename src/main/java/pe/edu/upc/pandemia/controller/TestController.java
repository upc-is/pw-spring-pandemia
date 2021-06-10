package pe.edu.upc.pandemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")	// GET y POST
public class TestController {

	@GetMapping
	public String response() {
		return "pagina";
	}
	
	@PostMapping
	public String response2() {
		return "pagina2";
	}
	
	@GetMapping("interno") // /test/interno
	public String interno() {
		return "pagina2";
	}
	
	@GetMapping("interno/subinterno") // /test/interno
	public String interno1() {
		return "pagina";
	}
	@GetMapping("layout")
	public String layout() {
		return "layout/layout";
	}
}
