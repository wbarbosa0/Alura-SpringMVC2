package br.nom.wbarbosa.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.nom.wbarbosa.mvc.mudi.dto.NovaOfertaDto;
import br.nom.wbarbosa.mvc.mudi.model.entity.Oferta;
import br.nom.wbarbosa.mvc.mudi.model.entity.Pedido;
import br.nom.wbarbosa.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody NovaOfertaDto novaOfertaDto) {

		Optional<Pedido> optPedido = pedidoRepository.findById(novaOfertaDto.getPedidoId());

		System.out.println(novaOfertaDto);

		Pedido pedido = optPedido.get();

		Oferta oferta = novaOfertaDto.toOferta();
		oferta.setPedido(pedido);

		pedido.getOfertas().add(oferta);
		pedidoRepository.save(pedido);

		return oferta;

	}
}
