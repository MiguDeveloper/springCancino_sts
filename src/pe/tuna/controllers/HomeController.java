package pe.tuna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("persona", new Persona());
		return "home/form";
	}
	
	@PostMapping("/form")
	public String submit(Persona persona, ModelMap model) {
		model.addAttribute("nombre", persona.getNombre());
		model.addAttribute("correo", persona.getCorreo());
		model.addAttribute("edad", persona.getEdad());
		return "home/data";
	}
}
