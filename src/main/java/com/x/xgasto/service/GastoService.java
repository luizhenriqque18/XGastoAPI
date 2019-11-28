package com.x.xgasto.service;

import com.x.xgasto.domain.Gasto;
import com.x.xgasto.domain.Usuario;

public interface GastoService {
    Gasto create(Gasto gasto);

    Gasto findById(Long idGasto);

    void delete(Gasto gasto);
}
