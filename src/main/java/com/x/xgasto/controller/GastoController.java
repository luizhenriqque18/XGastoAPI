package com.x.xgasto.controller;

import com.x.xgasto.domain.CategoriaGasto;
import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Gasto;
import com.x.xgasto.dto.GastoDto;
import com.x.xgasto.response.Response;
import com.x.xgasto.service.impl.CategoriaGastoServiceImpl;
import com.x.xgasto.service.impl.ContaServiceImpl;
import com.x.xgasto.service.impl.GastoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/gasto")
@CrossOrigin(origins = "*")
public class GastoController {

    @Autowired
    private GastoServiceImpl gastoService;

    @Autowired
    private ContaServiceImpl contaService;

    @Autowired
    private CategoriaGastoServiceImpl categoriaGastoService;

    @PostMapping("create")
    public ResponseEntity<Response<GastoDto>> create (@RequestParam("IdConta") Long idConta,
                                                      @RequestParam("IdCategoria") Long idCategoria,
                                                      @RequestBody GastoDto gastoDto){

        List<String> listErrors = new ArrayList<String>();

        Conta conta = this.contaService.findById(idConta);

        if(conta == null){
            listErrors.add("Conta não existe!!!");
            return ResponseEntity.badRequest().body(new Response<GastoDto>(null, listErrors));
        }

        CategoriaGasto categoriaGasto = this.categoriaGastoService.findById(idCategoria);

        if(categoriaGasto == null){
            listErrors.add("Categoria para gasto não existe!!! Escolha um categoria válida.");
            return ResponseEntity.badRequest().body(new Response<GastoDto>(null, listErrors));
        }

        Gasto gasto = gastoDto.convertDtoParaGasto(gastoDto);
        gasto.setConta(conta);
        gasto.setCategoriaGasto(categoriaGasto);

        this.gastoService.create(gasto);

        if(gasto == null){
            listErrors.add("Não foi possivel criar Gasto. Tente Novamente!!!");
            return ResponseEntity.badRequest().body(new Response<GastoDto>(null, listErrors));
        }

        return ResponseEntity.ok(new Response<GastoDto>(new GastoDto().convertGastoParaDto(gasto),null));
    }

    @PutMapping("update")
    private ResponseEntity<Response<GastoDto>> update (@RequestParam("idGasto") Long idGasto,
                                                       @RequestParam("idCategoria") Long idCategoria,
                                                       @RequestBody GastoDto gastoDto) {
        List<String> listErrors = new ArrayList<String>();

        Gasto gasto = this.gastoService.findById(idGasto);

        if(gasto == null){
            listErrors.add("Gasto não existe!!!");
            return ResponseEntity.badRequest().body(new Response<GastoDto>(null, listErrors));
        }

        CategoriaGasto categoriaGasto = this.categoriaGastoService.findById(idCategoria);

        if(categoriaGasto == null){
            listErrors.add("Categoria para gasto não existe!!! Escolha um categoria válida.");
            return ResponseEntity.badRequest().body(new Response<GastoDto>(null, listErrors));
        }

        gasto.setCategoriaGasto(categoriaGasto);
        gasto.setDescricao(gastoDto.getDescricao());
        gasto.setParcela(gastoDto.getParcela());
        gasto.setPercelaFixa(gastoDto.getPercelaFixa());
        gasto.setValor(gastoDto.getValor());

        gasto = this.gastoService.create(gasto);

        if(gasto == null){
            listErrors.add("Não foi possivel atualizar Gasto. Tente Novamente!!!");
            return ResponseEntity.badRequest().body(new Response<GastoDto>(null, listErrors));
        }

        return ResponseEntity.ok(new Response<GastoDto>(new GastoDto().convertGastoParaDto(gasto),null));
    }

    @DeleteMapping(value = "delete/{idGasto}")
    public ResponseEntity<Response<String>> delete(@PathVariable("idGasto") Long idGasto){

        List<String> listErrors = new ArrayList<String>();

        Gasto gasto = this.gastoService.findById(idGasto);

        if(gasto == null){
            listErrors.add("Gasto não encontrado!!!");
            return ResponseEntity.badRequest().body(new Response<String>(null, listErrors));
        }

        this.gastoService.delete(gasto);

        return ResponseEntity.ok(new Response<String>("Sucesses", null));
    }
}
