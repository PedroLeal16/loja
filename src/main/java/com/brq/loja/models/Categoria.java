package com.brq.loja.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoriaId")
    private Long id;

    @Getter @Setter
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {

        this.nome = nome;
    }

    

}
