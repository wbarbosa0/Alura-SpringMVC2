package br.nom.wbarbosa.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.nom.wbarbosa.mvc.mudi.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
