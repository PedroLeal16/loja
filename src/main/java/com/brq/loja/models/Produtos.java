package com.brq.loja.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String titulo;

    @Getter
    @Setter
    private double preco;

    @Getter
    @Setter
    private String descricao;

    @Getter
    @Setter 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @Getter
    @Setter
    private String urlImagem;

    public Produtos() {
    }

    public Produtos(String titulo, double preco, String descricao, Categoria categoria, String urlImagem) {

        this.titulo = titulo;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
        this.urlImagem = urlImagem;
        
    }
 
}
