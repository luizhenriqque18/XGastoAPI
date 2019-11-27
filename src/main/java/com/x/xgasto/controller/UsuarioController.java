package com.x.xgasto.controller;


import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.dto.UsuarioDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.impl.ContaServiceImpl;
import com.x.xgasto.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("api/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ContaServiceImpl contaService;


    @PostMapping(value = "signIn")
    public ResponseEntity<Response<UsuarioDto>> signIn(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password){

        boolean pessoa = this.usuarioService.verifyEmail(email, password);

        if(!pessoa){
            List<String> errosList = new Response<UsuarioDto>().getErrors();
            errosList.add("Verifique seu email ou senha solicitados!!!");

            return ResponseEntity.badRequest().body(new Response<UsuarioDto>(null, errosList));
        }

        Usuario usuario = this.usuarioService.searchEmail(email);
        usuario.setConta(this.contaService.findByContaByUsuario(usuario.getId()));

        return ResponseEntity.ok(new Response<UsuarioDto>(new UsuarioDto().convertUsuarioParaDto(usuario), null));
    }

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
