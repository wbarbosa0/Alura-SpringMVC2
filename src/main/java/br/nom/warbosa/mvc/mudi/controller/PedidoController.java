package br.nom.warbosa.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.nom.warbosa.mvc.mudi.dto.NovoPedidoDto;
import br.nom.warbosa.mvc.mudi.model.entity.Pedido;
import br.nom.warbosa.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public ModelAndView home(NovoPedidoDto novoPedidoDto) {
		ModelAndView mv = new ModelAndView("pedido/formulario");

		return mv;
	}

	@PostMapping("novo")
	public ModelAndView home(@Valid NovoPedidoDto novoPedidoDto, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/home");

		if (result.hasErrors()) {
			return mv;
		}

		Pedido pedido = novoPedidoDto.toPedido();
		pedidoRepository.save(pedido);
		return mv;
	}

}