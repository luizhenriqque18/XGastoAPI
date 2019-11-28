package com.x.xgasto.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.domain.Banco;

import java.math.BigDecimal;

public class BancoDto {

    @JsonIgnore
    private Long id;

    private String imgUrl;

    private String descricao;

    private BigDecimal saldo;

    public BancoDto(Long id, String imgUrl, String descricao, BigDecimal saldo) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.descricao = descricao;
        this.saldo = saldo;
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

    public Banco convertDtoParaBanco(BancoDto bancoDto){
        return new Banco(bancoDto.imgUrl, bancoDto.descricao, bancoDto.saldo);
    }

    public BancoDto convertBancoParaDto(Banco banco){
        return new BancoDto(banco.getId(), banco.getImgUrl(), banco.getDescricao(), banco.getSaldo());
    }
}
