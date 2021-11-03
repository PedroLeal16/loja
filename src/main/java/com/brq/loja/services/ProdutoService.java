package com.brq.loja.services;

import com.brq.loja.models.Categoria;
import com.brq.loja.models.Produtos;
import com.brq.loja.models.request.ProdutosRequest;
import com.brq.loja.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repostory;

    @Autowired
    CategoriaService categoriaService;

    public String salvar(Produtos produto) {

        repostory.save(produto);

        return "Cadastro feito com sucesso";
        
    }

    public Produtos buscaProduto(Long id) {

        Produtos p = repostory.getById(id);

        return p;
        
    }

    public Produtos atualizar(Long id, ProdutosRequest pr) {

        Produtos p = buscaProduto(id);

        Categoria categoria = categoriaService.buscar(pr.getCategoria().getId());

        p.setCategoria(categoria);
        p.setDescricao(pr.getDescricao());
        p.setPreco(pr.getPreco());
        p.setTitulo(pr.getTitulo());
        p.setUrlImagem(pr.getUrlImagem());

        return p;

    }

    public String deletar(Long id) {

        repostory.deleteById(id);

        return "Produto deletado com sucesso";
    }

}
