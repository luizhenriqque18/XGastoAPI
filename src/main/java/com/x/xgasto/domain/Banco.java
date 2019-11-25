package com.x.xgasto.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Conta conta;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Embedded
    private Audit audit = new Audit();
}
