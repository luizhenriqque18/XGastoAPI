package com.x.xgasto.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "categoria")
    private List<Gasto> gasto;

    @Column(name = "color")
    private String color;

    @Column(name = "nome")
    private  String nome;
}
