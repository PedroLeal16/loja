package com.brq.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuarioCEP")
public class CEP {

    @Getter @Id
    private Long cepUsuario;

    @Getter @Setter
    private String estado;

    @Getter @Setter
    private String cidade;

    @Getter @Setter
    private String bairro;

    @Getter @Setter
    private String ruaAvenida;

    @Getter @Setter
    private int numero;
    
    @Getter @Setter
    private String dadosAdicionais;
   
    public CEP() {
    }

    public CEP(Long cepUsuario, String estado, String cidade, String bairro, String ruaAvenida, int numero,
            String dadosAdicionais) {

        this.cepUsuario = cepUsuario;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.ruaAvenida = ruaAvenida;
        this.numero = numero;
        this.dadosAdicionais = dadosAdicionais;
    }

}
