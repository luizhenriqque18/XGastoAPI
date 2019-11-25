package com.x.xgasto.service.impl;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.dto.PessoaDto;

import java.util.List;

public interface PessoaServiceImpl {

    List<Pessoa> GetAllPessoa();

    Pessoa cadastrar(Pessoa pessoa);
}
