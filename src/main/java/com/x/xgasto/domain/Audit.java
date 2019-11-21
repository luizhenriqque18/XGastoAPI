package com.x.xgasto.domain;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class Audit {

    @Column(name = "dataCriacao")
    private Date dataCriacao;

    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @PrePersist
    public void PrePersist() {
        Date dateNow = new Date();
        setDataCriacao(dateNow);
        setDataAtualizacao(dateNow);
    }

    @PreUpdate
    public void PreUpdate() {
        setDataAtualizacao(new Date());
    }
}
