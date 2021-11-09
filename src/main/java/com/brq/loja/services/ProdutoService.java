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

    public String salvar(Produtos produto) throws Exception {

        try {
            
            repostory.save(produto);
    
            return "Cadastro de Produto feito com sucesso!";

        } catch (Exception e) {
            
            throw new Exception("Não foi possivel salvar o produto!");

        }

        
    }

    public Produtos buscaProduto(Long id) throws Exception {

        try {
            
            Produtos p = repostory.getById(id);

            if (p.getId() == null) throw new Exception();
    
            return p;


        } catch (Exception e) {
            
            throw new Exception("Não foi possivel encontrar o produto!");

        }
        
    }

    public Produtos atualizar(Long id, ProdutosRequest pr) throws Exception {

        try {
            
            Produtos p = buscaProduto(id);
    
            Categoria categoria = categoriaService.buscar(pr.getCategoria().getId());
    
            p.setCategoria(categoria);
            p.setDescricao(pr.getDescricao());
            p.setPreco(pr.getPreco());
            p.setTitulo(pr.getTitulo());
            p.setUrlImagem(pr.getUrlImagem());
    
            return p;

        } catch (Exception e) {
            
            throw new Exception(e.getMessage());

        }


    }

    public String deletar(Long id) throws Exception {

        try {
            
            repostory.deleteById(id);
    
            return "Produto deletado com sucesso!";

        } catch (Exception e) {
        
            throw new Exception("Id não encontrado!");
            
        }
    }

    public Produtos criaProduto(@Valid ProdutosRequest pr, Categoria categoria) {
   
        Produtos produto = new Produtos(pr.getTitulo(), pr.getPreco(), pr.getDescricao(),
        categoria, pr.getUrlImagem());

        return produto;
   
    }

    public void validaProduto(ProdutosRequest pr) throws Exception {

        try {
            
            String s2 = pr.getTitulo().trim();
            List<Produtos> produtos = repostory.findAll();
    
            if (!produtos.isEmpty()) {
    
                for (Produtos p : produtos) {
    
                    String s1 = p.getTitulo().trim();
    
                    if (s1.equalsIgnoreCase(s2)) throw new Exception();
    
                }
                
            }

        } catch (Exception e) {
            
            throw new Exception("Titulo ja em uso!");

        }

    }

}
