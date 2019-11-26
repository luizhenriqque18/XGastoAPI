package com.x.xgasto.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CategoriaGasto")
public class CategoriaGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "categoriaGasto")
    private List<Gasto> gasto;

    @Column(name = "color")
    private String color;

    @Column(name = "nome")
    private  String nome;
}
