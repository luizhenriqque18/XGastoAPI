package com.x.xgasto.repository;

import com.x.xgasto.domain.Banco;
import com.x.xgasto.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<Banco, Long> {

}
