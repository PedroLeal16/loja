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
    
    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String telefone;

    @Getter @Setter
    private String cpfCnpj;

    @Getter @Setter @OneToMany
    private List<CEP> ceps;

    public Usuario() {
    }

    public Usuario(String name, String telefone, String cpfCnpj, List<CEP> ceps) {

        this.name = name;
        this.telefone = telefone;
        this.cpfCnpj = cpfCnpj;
        this.ceps = ceps;
        
    }

}
