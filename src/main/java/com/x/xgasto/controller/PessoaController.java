package com.x.xgasto.controller;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.dto.PessoaDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.impl.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Response<PessoaDto>> create(@Valid @RequestBody PessoaDto pessoaDto, BindingResult result){

        if(result.hasErrors()){
            List<String> listErros = result.getAllErrors()
                                            .stream()
                                            .map( error -> error.getDefaultMessage())
                                            .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(new Response<PessoaDto>(null, listErros));
        }

        Pessoa pessoa = pessoaDto.convertDtoParaPessoa(pessoaDto);

        this.pessoaService.create(pessoa);

        return ResponseEntity.ok(new Response<PessoaDto>(pessoaDto.convertPessoaParaDto(pessoa), null));
    }

    @GetMapping(value = "findById/{id}")
    public ResponseEntity<Response<PessoaDto>>findById (@PathVariable("id") Long id){

        Pessoa pessoa = pessoaService.findById(id);

        if(pessoa == null){
            List<String> listErros = new ArrayList<String>();
            listErros.add("Pessoa não encontrada para o ID:" + id);

            return ResponseEntity.badRequest().body( new Response<PessoaDto>(null, listErros ));
        }

        return ResponseEntity.ok(new Response<PessoaDto>( new PessoaDto().convertPessoaParaDto(pessoa), null));
    }
}
