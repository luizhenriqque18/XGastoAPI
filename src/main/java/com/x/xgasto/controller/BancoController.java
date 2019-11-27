package com.x.xgasto.controller;

import com.x.xgasto.domain.Banco;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.dto.BancoDto;
import com.x.xgasto.dto.PessoaDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.impl.BancoServiceImpl;
import com.x.xgasto.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/banco")
public class BancoController {

    @Autowired
    private BancoServiceImpl bancoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping(name = "create")
    public ResponseEntity<Response<BancoDto>> create(@RequestParam("idUsuario") Long idUsuario,
                                                     @RequestBody BancoDto bancoDto){
        List<String> listErrors = new ArrayList<String>();

        Usuario usuario = this.usuarioService.findById(idUsuario);

        if(usuario == null){
            listErrors.add("Erro no usurio!!!");
            return ResponseEntity.badRequest().body(new Response<BancoDto>(null, listErrors));
        }

        Banco banco = this.bancoService.createOrUpdate(bancoDto.convertDtoParaBanco(bancoDto));

        if(banco == null){
            listErrors.add("Não foi possivel criar Banco. Tente Novamente!!!");
            return ResponseEntity.badRequest().body(new Response<BancoDto>(null, listErrors));
        }

        boolean isNotJoinContaWithBanco = this.bancoService.joinContaWithBanco(banco, usuario);

        if(isNotJoinContaWithBanco){
            listErrors.add("Não foi possivel criar Banco. Tente Novamente!!!");
            return ResponseEntity.badRequest().body(new Response<BancoDto>(null, listErrors));
        }

        return ResponseEntity.ok(new Response<BancoDto>(bancoDto.convertBancoParaDto(banco), null));
    }

    @PutMapping("update")
    public ResponseEntity<Response<BancoDto>> update(@RequestParam("idBanco") Long idBanco,
                                                  @RequestBody BancoDto bancoDto){
        List<String> listErrors = new ArrayList<String>();

        Banco banco = this.bancoService.findById(idBanco);

        if(banco == null){
            listErrors.add("Banco não encontrado!!!");
            return ResponseEntity.badRequest().body(new Response<BancoDto>(null, listErrors));
        }

        banco.setDescricao(bancoDto.getDescricao());
        banco.setImgUrl(bancoDto.getImgUrl());
        banco.setSaldo(bancoDto.getSaldo());

        banco = this.bancoService.createOrUpdate(banco);

        if(banco == null){
            listErrors.add("Banco não foi atualizado!!!");
            return ResponseEntity.badRequest().body(new Response<BancoDto>(null, listErrors));
        }

        return ResponseEntity.ok(new Response<BancoDto>(bancoDto.convertBancoParaDto(banco), null));
    }

    @DeleteMapping(value = "delete/{idBanco}")
    public ResponseEntity<Response<String>> delete(@PathVariable("idBanco") Long idBanco){

        List<String> listErrors = new ArrayList<String>();

        Banco banco = this.bancoService.findById(idBanco);

        if(banco == null){
            listErrors.add("Banco não encontrado!!!");
            return ResponseEntity.badRequest().body(new Response<String>(null, listErrors));
        }

        this.bancoService.delete(banco);

        return ResponseEntity.ok(new Response<String>("Sucesses", null));
    }
}
