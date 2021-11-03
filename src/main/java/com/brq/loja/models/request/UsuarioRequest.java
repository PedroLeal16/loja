package com.brq.loja.models.request;

import lombok.Getter;
import lombok.Setter;

public class UsuarioRequest {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String telefone;

    @Getter
    @Setter
    private String cpfCnpj;

    @Getter
    @Setter
    private CEPRequest ceps;
    
}
