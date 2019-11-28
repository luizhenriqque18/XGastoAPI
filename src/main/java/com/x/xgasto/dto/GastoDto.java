package com.x.xgasto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.domain.CategoriaGasto;
import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Gasto;

import java.math.BigDecimal;

public class GastoDto {

    private Long id;

    @JsonIgnore
    private Conta conta;

    @JsonIgnore
    private CategoriaGasto categoriaGasto;

    private String descricao;

    private BigDecimal valor;

    private Long parcela;

    private Long percelaFixa;

    public GastoDto() {
    }

    public GastoDto(Long id, String descricao, BigDecimal valor, Long parcela, Long percelaFixa) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.parcela = parcela;
        this.percelaFixa = percelaFixa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public CategoriaGasto getCategoriaGasto() {
        return categoriaGasto;
    }

    public void setCategoriaGasto(CategoriaGasto categoriaGasto) {
        this.categoriaGasto = categoriaGasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getParcela() {
        return parcela;
    }

    public void setParcela(Long parcela) {
        this.parcela = parcela;
    }

    public Long getPercelaFixa() {
        return percelaFixa;
    }

    public void setPercelaFixa(Long percelaFixa) {
        this.percelaFixa = percelaFixa;
    }

    public Gasto convertDtoParaGasto(GastoDto gastoDto){
        return new Gasto(gastoDto.getDescricao(), gastoDto.getValor(), gastoDto.parcela, gastoDto.getPercelaFixa());
    }

    public GastoDto convertGastoParaDto(Gasto gasto){
        return new GastoDto(gasto.getId(), gasto.getDescricao(),gasto.getValor(),gasto.getParcela(), gasto.getPercelaFixa());
    }
}
