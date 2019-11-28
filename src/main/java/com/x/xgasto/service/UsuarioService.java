package com.x.xgasto.service;

import com.x.xgasto.domain.Usuario;

public interface UsuarioService {

    Usuario create(Usuario usuario);

    boolean verifyEmail(String email, String password);

    Usuario searchEmail(String email);

    Usuario findById(Long id);
}
