package com.x.xgasto.service;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.dto.PessoaDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PessoaServiceImpl {

    public Pessoa findById(Long id);

    public Pessoa registerUser(Pessoa pessoa);
}
