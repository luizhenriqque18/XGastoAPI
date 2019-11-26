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
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "parcela")
    private Long parcela;

    @Column(name = "percelaFixa")
    private Long percelaFixa;

    @Embedded
    private Audit audit = new Audit();

}
