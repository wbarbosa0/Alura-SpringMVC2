package br.nom.wbarbosa.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

	@GetMapping(value = { "/hello/{name}", "/hello" })
	public String hello(Model model, @PathVariable(required = false) String name) {
		model.addAttribute("name", name);
		return "hello";
	}
}
