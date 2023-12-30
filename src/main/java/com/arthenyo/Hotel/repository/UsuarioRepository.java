package com.arthenyo.Hotel.repository;

import com.arthenyo.Hotel.model.Usuario;
import com.arthenyo.Hotel.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query(nativeQuery = true, value = """
			SELECT tb_usuario.email AS username, tb_usuario.senha As password, tb_acesso.id AS roleId, tb_acesso.descricao As authority
			FROM tb_usuario
			INNER JOIN tb_usuarios_acesso ON usuario.id = tb_usuarios_acesso.usuario_id
			INNER JOIN tb_acesso ON acesso.id = tb_usuarios_acesso.acesso_id
			WHERE tb_usuario.email = :email
		""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
}
