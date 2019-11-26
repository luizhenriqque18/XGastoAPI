package com.x.xgasto.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria_receita")
public class CategoriaReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "categoriaReceita")
    private List<Receita> receita;

    @Column(name = "color")
    private String color;

    @Column(name = "nome")
    private String nome;
}
