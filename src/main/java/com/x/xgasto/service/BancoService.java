package com.x.xgasto.service;

import com.x.xgasto.domain.Banco;
import com.x.xgasto.domain.Usuario;

public interface BancoService {

    Banco createOrUpdate(Banco banco);

    Banco findById(Long idBanco);

    Boolean joinContaWithBanco(Banco banco, Usuario usuario);

    void delete(Banco banco);
}
