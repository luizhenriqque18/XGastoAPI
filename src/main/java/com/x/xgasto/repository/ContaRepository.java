package com.x.xgasto.repository;

import com.x.xgasto.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

   Optional<List<Conta>> findByUsuarioId(Long id);
}
