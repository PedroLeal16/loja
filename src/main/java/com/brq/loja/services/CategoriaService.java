package com.brq.loja.services;

import java.util.List;

import com.brq.loja.models.Categoria;
import com.brq.loja.models.request.CategoriaRequest;
import com.brq.loja.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria buscar(Long id) throws Exception {

        try {
            
            Categoria categoria = repository.getById(id);

            if (categoria.getId() == null) throw new Exception();
    
            return categoria;

        } catch (Exception e) {
        
            throw new Exception("Não foi possivel encontrar a categoria!");
            
        }

    }

    public Categoria compararCategoria(CategoriaRequest cr) {

        String s2 = cr.getNome().toUpperCase().trim();
        List<Categoria> categorias = repository.findAll();

        if (!categorias.isEmpty()) {

            for (Categoria categoria : categorias) {

                String s1 = categoria.getNome().toUpperCase().trim();

                if (s1.equals(s2)) return categoria;
                
            }
            
        }

        Categoria categoria = new Categoria(cr.getNome());

        return categoria;
        
    }

    public void validaCategoria(CategoriaRequest categoria) throws Exception {

        try {
            
            if (categoria.getNome().isEmpty()) throw new Exception();
            
        } catch (Exception e) {

            throw new Exception("Nome de categoria não pode estar vazio!");

        }

    }
    
}
