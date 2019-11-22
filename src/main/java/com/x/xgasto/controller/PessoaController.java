package com.x.xgasto.controller;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.dto.PessoaDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Response<PessoaDto>> cadastrar(@RequestBody PessoaDto pessoaDto){
        pessoaDto.setId(1L);

        return ResponseEntity.ok(new Response<PessoaDto>(pessoaDto));
    }

    @GetMapping(value = "{nome}")
    public List<Pessoa> listPessoa (@PathVariable("nome") String nome){
        return pessoaService.GetAllPessoa();
    }
}
