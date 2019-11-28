package com.x.xgasto.service.impl;

import com.x.xgasto.domain.Conta;
import com.x.xgasto.repository.ContaRepository;
import com.x.xgasto.repository.UsuarioRepository;
import com.x.xgasto.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Conta> findByContaByUsuario(Long id) {
        return this.contaRepository.findByUsuarioId(id).orElse(null);
    }

    @Override
    public Conta createOrUpdate(Conta conta) {
        return this.contaRepository.save(conta);
    }

    @Override
    public Conta findById(Long idConta) {
        return this.contaRepository.findById(idConta).orElse(null);
    }

    @Override
    public void delete(Conta conta) {
        this.contaRepository.delete(conta);
    }
}
