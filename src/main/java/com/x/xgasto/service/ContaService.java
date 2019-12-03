package com.x.xgasto.service;

import com.x.xgasto.domain.Conta;

import java.util.List;

public interface ContaService {

    List<Conta> findByContaByUsuario(Long idUsuario);

    Conta createOrUpdate(Conta conta);

    Conta findById(Long idConta);

    void delete(Conta conta);
}
