package com.x.xgasto.service;


import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> GetAllPessoa(){
        return pessoaRepository.findAll();
    }
}
