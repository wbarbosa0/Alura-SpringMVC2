package br.nom.wbarbosa.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.nom.wbarbosa.mvc.mudi.model.entity.Pedido;
import br.nom.wbarbosa.mvc.mudi.model.entity.StatusPedido;

public class NovoPedidoDto {
	@NotBlank
	@Size(max = 255, min = 3)
	private String nomeProduto;

	@NotBlank
	@Size(max = 255, min = 3)
	private String urlProduto;

	@NotBlank
	@Size(max = 255, min = 3)
	private String urlImagemProduto;

	@Size(max = 255)
	private String descricao;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagemProduto() {
		return urlImagemProduto;
	}

	public void setUrlImagemProduto(String urlImagemProduto) {
		this.urlImagemProduto = urlImagemProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public br.nom.wbarbosa.mvc.mudi.model.entity.Pedido toPedido() {
		Pedido pedido = new br.nom.wbarbosa.mvc.mudi.model.entity.Pedido();

		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagemProduto(urlImagemProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);

		return pedido;
	}
}
