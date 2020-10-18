package br.nom.wbarbosa.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.nom.wbarbosa.mvc.mudi.model.entity.Oferta;

public class NovaOfertaDto {
	private Long pedidoId;

	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	private String valor;

	@NotNull
	@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(0[1-9]|1[0-2])/[2-9][0-9]{3}$")
	private String dataEntrega;
	private String comentario;

	static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	@Override
	public String toString() {
		return "NovaOfertaDto [pedidoId=" + pedidoId + ", valor=" + valor + ", dataEntrega=" + dataEntrega
				+ ", comentario=" + comentario + "]";
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
		oferta.setValor(new BigDecimal(this.valor));
		return oferta;
	}
}
