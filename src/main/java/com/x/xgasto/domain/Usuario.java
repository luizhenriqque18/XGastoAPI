package com.x.xgasto.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private Long id;

    @OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private Date dataCriacao;

    private Date dataAtualizacao;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return password;
    }

    public void setSenha(String senha) {
        this.password = senha;
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
}
