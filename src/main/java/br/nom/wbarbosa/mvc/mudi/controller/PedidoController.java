package br.nom.wbarbosa.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.nom.wbarbosa.mvc.mudi.dto.NovoPedidoDto;
import br.nom.wbarbosa.mvc.mudi.model.entity.Pedido;
import br.nom.wbarbosa.mvc.mudi.model.entity.Usuario;
import br.nom.wbarbosa.mvc.mudi.repository.PedidoRepository;
import br.nom.wbarbosa.mvc.mudi.repository.UsuarioRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("formulario")
	public ModelAndView home(NovoPedidoDto novoPedidoDto) {
		ModelAndView mv = new ModelAndView("pedido/formulario");

		return mv;
	}

	@PostMapping("novo")
	public ModelAndView home(@Valid NovoPedidoDto novoPedidoDto, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/home");

		System.out.println("Inicio");
		if (result.hasErrors()) {
			return mv;
		}
		System.out.println("Passou hasErrors");

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Pedido pedido = novoPedidoDto.toPedido();
		Usuario usuario = usuarioRepository.getOne(username);
		pedido.setUsuario(usuario);
		pedidoRepository.save(pedido);
		return mv;
	}

}