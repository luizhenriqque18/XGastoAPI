package com.x.xgasto.service;

import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Gasto;
import com.x.xgasto.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario create(Usuario usuario);

    boolean verifyEmail(String email, String password);

    Usuario searchEmail(String email);
}
