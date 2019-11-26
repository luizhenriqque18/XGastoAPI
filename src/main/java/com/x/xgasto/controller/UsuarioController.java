package com.x.xgasto.controller;


import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.dto.PessoaDto;
import com.x.xgasto.dto.UsuarioDto;
import com.x.xgasto.enums.SexoEnum;
import com.x.xgasto.repository.PessoaRepository;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.impl.PessoaService;
import com.x.xgasto.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("api/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository r;

    /*@PostMapping
    public ResponseEntity<Response<UsuarioDto>> create(
            @RequestParam(name = "nome") String nome,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password){

        *//*if(result.hasErrors()){
            List<String> listErross = result.getAllErrors()
                    .stream()
                    .map( error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(new Response<UsuarioDto>(null, listErross));
        }*//*
//    this.teste();
        Pessoa pessoa = new Pessoa();
        Usuario usuario = new Usuario(email, password);
        pessoa.setNome(nome);
        pessoa.setUsuario(usuario);

//        this.usuarioService.create(usuario);
        Pessoa resp = this.pessoaService.create(pessoa);

        UsuarioDto usuarioDto = new UsuarioDto().convertUsuarioParaDto(resp.getUsuario());

        return ResponseEntity.ok(new Response<UsuarioDto>( usuarioDto, null));
    }*/

}
