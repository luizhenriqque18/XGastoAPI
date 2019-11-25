package com.x.xgasto.domain;

import javax.persistence.*;


@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToOne(mappedBy = "conta", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Banco banco;

    @Embedded
    private Audit audit = new Audit();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
