package com.x.xgasto.domain;

import com.x.xgasto.enums.SexoEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private SexoEnum sexo;

    @OneToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    private Date dataCriacao;

    private Date dataAtualizacao;


    public Pessoa() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    @PreUpdate
//    public Date PreUpdate() {
//        return dataAtualizacao = new Date();
//    }
//
//    @PrePersist
//    public void PrePersist(Date dataAtualizacao) {
//        final Date dateNow = new Date();
//        this.dataCriacao = dateNow;
//        this.dataAtualizacao = dateNow;
//    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", usuario=" + usuario +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}



