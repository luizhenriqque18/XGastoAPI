package com.x.xgasto.controller;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.dto.PessoaDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl pessoaServiceImpl;

    @PostMapping
    public ResponseEntity<Response<PessoaDto>> registerUser(
            @RequestParam(name = "nome") String nome,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password){

        Usuario usuario = new Usuario(email, password);
        Pessoa pessoa = new Pessoa();
        pessoa.setUsuario(usuario);
        pessoa.setNome(nome);

        this.pessoaServiceImpl.registerUser(pessoa);

        return ResponseEntity.ok(new Response<PessoaDto>(new PessoaDto().convertPessoaParaDto(pessoa), null));
    }


    @GetMapping(value = "findById/{id}")
    public ResponseEntity<Response<PessoaDto>>findById (@PathVariable("id") Long id){

        Pessoa pessoa = pessoaServiceImpl.findById(id);

        if(pessoa == null){
            List<String> listErros = new ArrayList<String>();
            listErros.add("Pessoa não encontrada para o ID:" + id);

            return ResponseEntity.badRequest().body( new Response<PessoaDto>(null, listErros ));
        }

        return ResponseEntity.ok(new Response<PessoaDto>( new PessoaDto().convertPessoaParaDto(pessoa), null));
    }


    private List<String> errosResponse(Errors errors){
        return errors.getAllErrors()
                .stream()
                .map( error -> error.getDefaultMessage())
                .collect(Collectors.toList());
    }

}
