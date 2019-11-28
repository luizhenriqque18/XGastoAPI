package com.x.xgasto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "conta",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Gasto> gastos;

    @JsonIgnore
    @OneToMany(mappedBy = "conta",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Receita> receitas;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Embedded
    private Audit audit = new Audit();

    public Conta() {

    }

    public Conta(String imgUrl, String descricao, BigDecimal saldo, Usuario usuario) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
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

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}
