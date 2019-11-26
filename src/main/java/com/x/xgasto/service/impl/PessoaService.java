package com.x.xgasto.service.impl;


import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.enums.SexoEnum;
import com.x.xgasto.repository.PessoaRepository;
import com.x.xgasto.service.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PessoaService implements PessoaServiceImpl {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa registerUser(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
