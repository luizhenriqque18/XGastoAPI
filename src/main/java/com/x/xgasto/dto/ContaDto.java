package com.x.xgasto.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Usuario;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ContaDto {

    private Long id;

    private String imgUrl;

    private String descricao;

    private BigDecimal saldo;

    @JsonIgnore
    private Usuario usuario;

    public ContaDto() {
    }

    public ContaDto(Long id, String imgUrl, String descricao, BigDecimal saldo, Usuario usuario) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.descricao = descricao;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conta convertDtoParaConta(ContaDto contaDto){
        return new Conta(contaDto.imgUrl, contaDto.descricao, contaDto.saldo, contaDto.usuario);
    }

    public ContaDto convertContaParaDto(Conta conta){
        return new ContaDto(conta.getId(), conta.getImgUrl(), conta.getDescricao(), conta.getSaldo(), conta.getUsuario());
    }

    public List<ContaDto > convertContaParaListConta(List<Conta> contaList){
        List<ContaDto> contaDtos = contaList.stream()
                .map(conta -> new ContaDto(conta.getId(), conta.getImgUrl(), conta.getDescricao(), conta.getSaldo(), conta.getUsuario()))
                .collect(Collectors.toList());
        return contaDtos;
    }
}
