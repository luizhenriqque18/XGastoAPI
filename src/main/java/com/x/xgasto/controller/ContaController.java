package com.x.xgasto.controller;

import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.dto.ContaDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.impl.ContaServiceImpl;
import com.x.xgasto.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/banco")
public class ContaController {

    @Autowired
    private ContaServiceImpl contaService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping(name = "create")
    public ResponseEntity<Response<ContaDto>> create(@RequestParam("idUsuario") Long idUsuario,
                                                     @RequestBody ContaDto contaDto){
        List<String> listErrors = new ArrayList<String>();

        Usuario usuario = this.usuarioService.findById(idUsuario);

        if(usuario == null){
            listErrors.add("Erro no usurio!!!");
            return ResponseEntity.badRequest().body(new Response<ContaDto>(null, listErrors));
        }

        contaDto.setUsuario(usuario);
        Conta conta = this.contaService.createOrUpdate(contaDto.convertDtoParaConta(contaDto));

        if(conta == null){
            listErrors.add("Não foi possivel criar Conta. Tente Novamente!!!");
            return ResponseEntity.badRequest().body(new Response<ContaDto>(null, listErrors));
        }

        return ResponseEntity.ok(new Response<ContaDto>(contaDto.convertContaParaDto(conta), null));
    }

    @PutMapping("update")
    public ResponseEntity<Response<ContaDto>> update(@RequestParam("idConta") Long idConta,
                                                     @RequestBody ContaDto contaDto){
        List<String> listErrors = new ArrayList<String>();

        Conta conta = this.contaService.findById(idConta);

        if(conta == null){
            listErrors.add("Conta não encontrado!!!");
            return ResponseEntity.badRequest().body(new Response<ContaDto>(null, listErrors));
        }

        conta.setDescricao(contaDto.getDescricao());
        conta.setImgUrl(contaDto.getImgUrl());
        conta.setSaldo(contaDto.getSaldo());

        conta = this.contaService.createOrUpdate(conta);

        if(conta == null){
            listErrors.add("Banco não foi atualizado!!!");
            return ResponseEntity.badRequest().body(new Response<ContaDto>(null, listErrors));
        }

        return ResponseEntity.ok(new Response<ContaDto>(contaDto.convertContaParaDto(conta), null));
    }

    @DeleteMapping(value = "delete/{idConta}")
    public ResponseEntity<Response<String>> delete(@PathVariable("idConta") Long idConta){

        List<String> listErrors = new ArrayList<String>();

        Conta banco = this.contaService.findById(idConta);

        if(banco == null){
            listErrors.add("Banco não encontrado!!!");
            return ResponseEntity.badRequest().body(new Response<String>(null, listErrors));
        }

        this.contaService.delete(banco);

        return ResponseEntity.ok(new Response<String>("Sucesses", null));
    }

    @GetMapping(value = "findConta/{idConta}")
    public ResponseEntity<Response<ContaDto>> findByIdConta(@PathVariable("idConta") Long idConta){
        List<String> listErrors = new ArrayList<String>();

        Conta conta = this.contaService.findById(idConta);

        if(conta == null){
            listErrors.add("Conta não encontrado!!!");
            return ResponseEntity.badRequest().body(new Response<ContaDto>(null, listErrors));
        }

        return ResponseEntity.ok(new Response<ContaDto>(new ContaDto().convertContaParaDto(conta), null));
    }
}
