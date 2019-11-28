package com.x.xgasto.repository;

import com.x.xgasto.domain.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

}
