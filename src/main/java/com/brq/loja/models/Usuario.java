package com.brq.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Getter @Id
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String telefone;

    public Usuario() {
    }

    public Usuario(Long id, String name, String telefone) {
        
        this.id = id;
        this.name = name;
        this.telefone = telefone;

    }

}
