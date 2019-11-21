package com.x.xgasto.controller;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.repository.PessoaRepository;
import com.x.xgasto.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "{nome}")
    public List<Pessoa> listPessoa (@PathVariable("nome") String nome){
        return pessoaService.GetAllPessoa();
    }
}
