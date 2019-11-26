package com.x.xgasto.repository;

import com.x.xgasto.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByNome(String nome);

    Optional<Pessoa> findById(Long id);
}
