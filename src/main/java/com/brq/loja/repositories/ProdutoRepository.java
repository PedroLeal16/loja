package com.brq.loja.repositories;

import com.brq.loja.models.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Long>{
    
}
