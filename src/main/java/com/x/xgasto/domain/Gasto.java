package com.x.xgasto.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "gasto")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @ManyToOne()
    @JoinColumn(name = "cat_gasto_id")
    private CategoriaGasto categoriaGasto;

    @OneToMany(mappedBy = "gasto")
    private List<Pagamento> pagamentos;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "parcela")
    private Long parcela;

    @Column(name = "percelaFixa")
    private Long percelaFixa;

    @Embedded
    private Audit audit = new Audit();

    public Gasto() {
    }

    public Gasto(String descricao, BigDecimal valor, Long parcela, Long percelaFixa) {
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
}
