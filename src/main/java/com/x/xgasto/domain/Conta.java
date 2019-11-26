package com.x.xgasto.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "banco_id")
    private Banco banco;

    @OneToMany(mappedBy = "conta",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Gasto> gastos;

    @OneToMany(mappedBy = "conta",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Receita> receitas;

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
