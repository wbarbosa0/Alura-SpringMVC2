package br.nom.wbarbosa.mvc.mudi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.nom.wbarbosa.mvc.mudi.security.AcessoInterceptor;
import br.nom.wbarbosa.mvc.mudi.security.AcessoInterceptor.Acesso;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

	@GetMapping
	public List<Acesso> listarAcessos() {
		return AcessoInterceptor.acessos;
	}
}
