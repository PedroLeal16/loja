package com.brq.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

    @Getter @Id
    private Long id;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private double preco;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private String categoria;

    @Getter @Setter
    private String urlImagem;
    
}
