package br.nom.wbarbosa.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.nom.wbarbosa.mvc.mudi.model.entity.Pedido;
import br.nom.wbarbosa.mvc.mudi.model.entity.StatusPedido;
import br.nom.wbarbosa.mvc.mudi.repository.PedidoRepository;

@RequestMapping("/api/pedidos")
@RestController
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardando() {
		return (pedidoRepository.findByStatus(StatusPedido.AGUARDANDO,
				PageRequest.of(0, 10, Sort.by("id").descending())));
	}

}
