package com.brq.loja.models.request;

import lombok.Getter;
import lombok.Setter;

public class ProdutosRequest {
    
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
    private CategoriaRequest categoria;

    @Getter
    @Setter
    private String urlImagem;

}
