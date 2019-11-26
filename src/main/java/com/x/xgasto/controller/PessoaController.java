package com.x.xgasto.controller;

import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.dto.PessoaDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.UsuarioService;
import com.x.xgasto.service.impl.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Response<PessoaDto>> registerUser(
            @RequestParam(name = "nome") String nome,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password){

        Usuario usuario = new Usuario(email, password);
        Pessoa pessoa = new Pessoa();
        pessoa.setUsuario(usuario);
        pessoa.setNome(nome);

        this.pessoaService.registerUser(pessoa);

        return ResponseEntity.ok(new Response<PessoaDto>(new PessoaDto().convertPessoaParaDto(pessoa), null));
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
