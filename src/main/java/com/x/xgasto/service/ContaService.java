package com.x.xgasto.service;

import com.x.xgasto.domain.Conta;

import java.util.List;

public interface ContaService {

    List<Conta> findByContaByUsuario(Long id);
}
