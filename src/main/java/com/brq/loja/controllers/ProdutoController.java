package com.brq.loja.controllers;

import com.brq.loja.models.Categoria;
import com.brq.loja.models.Produtos;
import com.brq.loja.models.request.ProdutosRequest;
import com.brq.loja.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    String s;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody ProdutosRequest pr) {

        Categoria categoria = new Categoria(pr.getCategoria().getNome());

        Produtos produto = new Produtos(pr.getTitulo(), pr.getPreco(), pr.getDescricao(),
        categoria, pr.getUrlImagem());

        s = service.salvar(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(s);
        
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody ProdutosRequest pr) {

        Produtos p = service.atualizar(id, pr);

        service.salvar(p);

        s = "Produto atualizado com sucesso!";

        return ResponseEntity.status(HttpStatus.OK).body(s);
        
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        
        s = service.deletar(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);

    }
    
}
