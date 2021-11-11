package com.brq.loja.services;

import com.brq.loja.models.CEP;
import com.brq.loja.models.Usuario;
import com.brq.loja.models.request.UsuarioRequest;
import com.brq.loja.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Usuario criaUsuario(UsuarioRequest ur) {

        Usuario usuario = new Usuario(ur.getName(), ur.getTelefone(), ur.getCpfCnpj());
        
        return usuario;
    }

    public String salvar(Usuario usuario) {
        
        repository.save(usuario);

        return "Usuario cadastrado com sucesso!";
    }

    public void atualizarCEP(CEP cep, Long idUsuario) {

        Usuario usuario = buscarUsuario(idUsuario);

        usuario.getCeps().add(cep);

        salvar(usuario);

    }

    private Usuario buscarUsuario(Long idUsuario) {
        
        return repository.getById(idUsuario);
    
    }

    public Usuario buscarUsuarioParaConsulta(Long idUsuario) {

        Usuario u = buscarUsuario(idUsuario);

        Usuario usuario = new Usuario();

        usuario.setName(u.getName());
        usuario.setTelefone(u.getTelefone());
        usuario.setCpfCnpj(u.getCpfCnpj());
        usuario.setCeps(u.getCeps());

        return usuario;
    
    }

    public Usuario atualizarUsuario(UsuarioRequest ur, Long id) {

        Usuario usuario = buscarUsuario(id);

        usuario.setName(ur.getName());
        usuario.setTelefone(ur.getTelefone());
        usuario.setCpfCnpj(ur.getCpfCnpj());

        return usuario;
    
    }

    public String deletar(Long id) {

        repository.deleteById(id);

        return "Usuario deletado com sucesso!";
    }
    

}
