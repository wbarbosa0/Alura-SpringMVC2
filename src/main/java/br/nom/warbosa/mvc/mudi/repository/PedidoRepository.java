package br.nom.warbosa.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.nom.warbosa.mvc.mudi.model.entity.Pedido;
import br.nom.warbosa.mvc.mudi.model.entity.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

}
