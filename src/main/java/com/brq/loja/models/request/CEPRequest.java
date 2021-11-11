package com.brq.loja.models.request;

import lombok.Getter;
import lombok.Setter;

public class CEPRequest {

    @Getter
    @Setter
    private Long idUsuario;

    @Getter
    @Setter
    private String cepUsuario;

    @Getter
    @Setter
    private String estado;

    @Getter
    @Setter
    private String cidade;

    @Getter
    @Setter
    private String bairro;

    @Getter
    @Setter
    private String ruaAvenida;

    @Getter
    @Setter
    private int numero;
    
    @Getter
    @Setter
    private String dadosAdicionais;
    
}
