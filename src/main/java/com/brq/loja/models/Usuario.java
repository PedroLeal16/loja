package com.brq.loja.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @OneToMany
    private List<CEP> ceps;

    public Usuario() {
    }

    public Usuario(String name, String telefone, String cpfCnpj, CEP cep) {

        this.name = name;
        this.telefone = telefone;
        this.cpfCnpj = cpfCnpj;
        this.ceps.add(cep);
        
    }

    public Usuario(String name, String telefone, String cpfCnpj) {

        this.name = name;
        this.telefone = telefone;
        this.cpfCnpj = cpfCnpj;

    }

}
