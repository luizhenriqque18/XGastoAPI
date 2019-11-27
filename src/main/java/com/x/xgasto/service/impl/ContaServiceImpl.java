package com.x.xgasto.service.impl;

import com.x.xgasto.domain.Conta;
import com.x.xgasto.repository.ContaRepository;
import com.x.xgasto.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public List<Conta> findByContaByUsuario(Long id) {
        return this.contaRepository.findByUsuarioId(id).orElse(null);
    }
}
