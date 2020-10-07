package br.nom.wbarbosa.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.nom.wbarbosa.mvc.mudi.model.entity.Pedido;
import br.nom.wbarbosa.mvc.mudi.model.entity.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

	@Query("select P from Pedido P join P.usuario U where U.username = :usuario")
	List<Pedido> findByUsuario(@Param("usuario") String usuario);

}
