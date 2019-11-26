package com.x.xgasto.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "cat_receita_id")
    private CategoriaReceita categoriaReceita;

    @Column(name = "valor")
    private BigDecimal valor;

    @Embedded
    private Audit audit = new Audit();
}
