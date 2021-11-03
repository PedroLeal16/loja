package com.brq.loja.services;

import com.brq.loja.models.Categoria;
import com.brq.loja.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria buscar(Long id) {

        Categoria categoria = repository.getById(id);

        return categoria;
    }

    
}
