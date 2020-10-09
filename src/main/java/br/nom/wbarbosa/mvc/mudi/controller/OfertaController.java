package br.nom.wbarbosa.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaController {

	@GetMapping("home")
	public String oferta() {
		return ("oferta/home");
	}
}
