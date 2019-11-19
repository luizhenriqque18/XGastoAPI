package com.x.xgasto.domain;


import com.x.xgasto.enums.SexoEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private SexoEnum sexo;

    private Date dataCriacao;
    private Date dataAtualizacao;


    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    @PreUpdate
    public Date PreUpdate() {
        return dataAtualizacao = new Date();
    }

    @PrePersist
    public void PrePersist(Date dataAtualizacao) {
        final Date dateNow = new Date();
        this.dataCriacao = dateNow;
        this.dataAtualizacao = dateNow;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}



