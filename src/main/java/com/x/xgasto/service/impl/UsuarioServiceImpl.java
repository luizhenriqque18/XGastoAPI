package com.x.xgasto.service.impl;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.repository.UsuarioRepository;
import com.x.xgasto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean verifyEmail(String email, String password) {
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);

        return usuario.isPresent() && (usuario.get().getPassword().equals(password));
    }

    @Override
    public Usuario searchEmail(String email) {
        return this.usuarioRepository.findByEmail(email).orElse(null);
    }


}
