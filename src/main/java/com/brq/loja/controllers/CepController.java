package com.brq.loja.controllers;

import com.brq.loja.models.CEP;
import com.brq.loja.models.request.CEPRequest;
import com.brq.loja.services.CepService;
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
@RequestMapping("/cep")
public class CepController {

    @Autowired
    CepService service;

    @Autowired
    UsuarioService usuarioService;

    String s;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody CEPRequest cepRequest) {

        CEP cep = new CEP(cepRequest.getCepUsuario(), cepRequest.getEstado(),
            cepRequest.getCidade(), cepRequest.getBairro(),
            cepRequest.getRuaAvenida(), cepRequest.getNumero(),
            cepRequest.getDadosAdicionais());

        s = service.salvar(cep);

        usuarioService.atualizarCEP(cep, cepRequest.getIdUsuario());

        return ResponseEntity.status(HttpStatus.CREATED).body(s);
        
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody CEPRequest cepRequest) {
 
        CEP cep = service.atualizar(id, cepRequest);

        service.salvar(cep);

        s = "CEP atualizado com sucesso!";

        return ResponseEntity.status(HttpStatus.OK).body(s);
        
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        s = service.deletar(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CEP> consultarCEP(@PathVariable Long id) {


        CEP cep = service.buscarParaConsulta(id);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cep);

    }
    
}
