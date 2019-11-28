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

    public CategoriaGasto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Gasto> getGasto() {
        return gasto;
    }

    public void setGasto(List<Gasto> gasto) {
        this.gasto = gasto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
