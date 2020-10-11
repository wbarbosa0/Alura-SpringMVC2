package br.nom.wbarbosa.mvc.mudi.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.nom.wbarbosa.mvc.mudi.model.entity.Oferta;

public class NovaOfertaDto {
	private Long pedido_id;
	private String valor;
	private String dataEntrega;
	private String comentario;

	static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Long getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(Long pedido_id) {
		this.pedido_id = pedido_id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, formatter));
		return oferta;
	}
}
