package br.nom.warbosa.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.nom.warbosa.mvc.mudi.model.entity.Pedido;
import br.nom.warbosa.mvc.mudi.model.entity.StatusPedido;
import br.nom.warbosa.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public ModelAndView home() {
		List<Pedido> pedidos = pedidoRepository.findAll();

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);

		return mv;
	}

	@GetMapping("{status}")
	public ModelAndView home(@PathVariable String status) {
		status = status.toUpperCase();
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status));

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		mv.addObject("status", status);

		return mv;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
