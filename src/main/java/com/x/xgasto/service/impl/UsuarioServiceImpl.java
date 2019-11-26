package com.x.xgasto.service.impl;

import com.x.xgasto.domain.Usuario;
import com.x.xgasto.repository.UsuarioRepository;
import com.x.xgasto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
