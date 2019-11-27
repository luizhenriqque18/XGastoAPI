package com.x.xgasto.repository;

import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(Long idUsuario);
}
