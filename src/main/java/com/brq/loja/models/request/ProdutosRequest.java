package com.brq.loja.models.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class ProdutosRequest {
    
    @Getter
    @Setter
    @NotBlank(message = "Titulo nao pode estar em branco!")
    private String titulo;

    @Getter
    @Setter
    @NotNull(message = "Preco nao pode ser nulo")
    private BigDecimal preco;

    @Getter
    @Setter
    @NotBlank(message = "Descricao nao pode estar em branco!")
    private String descricao;

    @Getter
    @Setter
    @NotNull(message = "Categoria nao pode ser nulo!")
    private CategoriaRequest categoria;

    @Getter
    @Setter
    @NotBlank(message = "Url da imagem nao pode estar em branco!")
    private String urlImagem;

}
