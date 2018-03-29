package pe.tuna.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.tuna.beans.Persona;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("saludo", "desde el controlador HOME");
		return "home/inicio";
	}
	@GetMapping("/nosotros/desarrollador/{id}")
	public String nosotros(@PathVariable int id , Model model) {
		model.addAttribute("saludo", "desde el controlador HOME id desarrollador: " + id);
		return "home/our";
	}
	
	@GetMapping("/addEmpleado")
	public String showForm(Model model) {
		model.addAttribute("persona", new Persona());
		return "home/form";
	}
	
	@PostMapping("/addEmpleado")
	public String submit(@Valid @ModelAttribute("persona") Persona persona, BindingResult result, SessionStatus status) {
		String view = "";
		if(result.hasErrors()) {
			view = "home/form";
		}else {
			// Si todos los datos fueron correctamente ingresados
			view = "home/data";
		}
		return view;
	}
	
	// Metodo para rellenar el select
	@ModelAttribute("lstPaises")
	public Map<String, String> getPaises(){
		Map<String, String> pais = new LinkedHashMap<>();
		pais.put("1", "Perú");
		pais.put("2", "Mexico");
		pais.put("3", "Colombia");
		pais.put("4", "Chile");
		pais.put("5", "Argentina");
		pais.put("6", "España");
		
		return pais;
	}
	
}
