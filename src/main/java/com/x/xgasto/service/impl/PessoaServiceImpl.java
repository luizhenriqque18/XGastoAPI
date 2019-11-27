package com.x.xgasto.service.impl;


import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService implements com.x.xgasto.service.PessoaService {

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
