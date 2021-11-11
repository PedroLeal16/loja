package com.brq.loja.controllers;

import com.brq.loja.models.Usuario;
import com.brq.loja.models.request.UsuarioRequest;
import com.brq.loja.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    String s;

    @Autowired
    UsuarioService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioRequest ur) {

        try {
            
            Usuario usuario = service.criaUsuario(ur);

            s = service.salvar(usuario);

            return ResponseEntity.status(HttpStatus.CREATED).body(s);

        } catch (Exception e) {
        
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            
        }
        
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody UsuarioRequest ur) {
        
        Usuario usuario = service.atualizarUsuario(ur, id);

        service.salvar(usuario);

        s = "Usuario atualizado com sucesso!";

        return ResponseEntity.status(HttpStatus.OK).body(s);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        s = service.deletar(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultaUsuario(@PathVariable Long id) {

        Usuario usuario = service.buscarUsuarioParaConsulta(id);

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
        
    }
    
}
