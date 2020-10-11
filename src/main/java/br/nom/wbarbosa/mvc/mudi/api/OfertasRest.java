package br.nom.wbarbosa.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.nom.wbarbosa.mvc.mudi.dto.NovaOfertaDto;
import br.nom.wbarbosa.mvc.mudi.model.entity.Oferta;
import br.nom.wbarbosa.mvc.mudi.model.entity.Pedido;
import br.nom.wbarbosa.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/oferta")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Oferta criaOferta(NovaOfertaDto novaOfertaDto) {

		Optional<Pedido> optPedido = pedidoRepository.findById(novaOfertaDto.getPedido_id());

		Pedido pedido = optPedido.get();

		Oferta oferta = novaOfertaDto.toOferta();
		oferta.setPedido(pedido);

		return oferta;

	}
}
