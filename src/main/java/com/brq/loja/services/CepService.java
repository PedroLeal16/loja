package com.brq.loja.services;

import com.brq.loja.models.CEP;
import com.brq.loja.models.request.CEPRequest;
import com.brq.loja.repositories.CepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    CepRepository repository;

    public String salvar(CEP cep) {
    
        repository.save(cep);

        return "CEP cadastrado com sucesso!";
    
    }

    public CEP atualizar(Long id, CEPRequest cepRequest) {

        CEP cep = buscar(id);

        cep.setBairro(cepRequest.getBairro());
        cep.setCepUsuario(cepRequest.getCepUsuario());
        cep.setCidade(cepRequest.getCidade());
        cep.setDadosAdicionais(cepRequest.getDadosAdicionais());
        cep.setEstado(cepRequest.getEstado());
        cep.setNumero(cepRequest.getNumero());
        cep.setRuaAvenida(cepRequest.getRuaAvenida());

        return cep;
    }

    public CEP buscar(Long id) {

        return repository.getById(id);
    
    }

    public String deletar(Long id) {

        repository.deleteById(id);

        return "CEP deletado com sucesso!";

    }

    public CEP buscarParaConsulta(Long id) {

        CEP cep = buscar(id);

        CEP c = new CEP();

        c.setBairro(cep.getBairro());
        c.setCepUsuario(cep.getCepUsuario());
        c.setCidade(cep.getCidade());
        c.setDadosAdicionais(cep.getDadosAdicionais());
        c.setEstado(cep.getEstado());
        c.setNumero(cep.getNumero());
        c.setRuaAvenida(cep.getRuaAvenida());

        return c;
    }
    
}
