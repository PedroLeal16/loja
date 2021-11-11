package com.brq.loja.repositories;

import com.brq.loja.models.CEP;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<CEP, Long>  {
    
}
