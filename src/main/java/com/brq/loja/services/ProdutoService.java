package com.brq.loja.services;

import java.util.List;

import javax.validation.Valid;

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

        return "Cadastro de Produto feito com sucesso!";
        
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

        return "Produto deletado com sucesso!";
    }

    public Produtos criaProduto(@Valid ProdutosRequest pr, Categoria categoria) {
   
        Produtos produto = new Produtos(pr.getTitulo(), pr.getPreco(), pr.getDescricao(),
        categoria, pr.getUrlImagem());

        return produto;
   
    }

    public void validaProduto(ProdutosRequest pr) throws Exception {

        try {
            
            String s2 = pr.getTitulo().trim().toUpperCase();
            List<Produtos> produtos = repostory.findAll();
    
            if (!produtos.isEmpty()) {
    
                for (Produtos p : produtos) {
    
                    String s1 = p.getTitulo().trim().toUpperCase();
    
                    if (s1.equals(s2)) throw new Exception();
    
                }
                
            }

        } catch (Exception e) {
            
            throw new Exception("Titulo ja em uso!");

        }

    }

}
