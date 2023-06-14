package com.reges.regesspring.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.reges.regesspring.models.ProdutoVenda;
import com.reges.regesspring.rdn.ProdutoRdn;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProdutoController {

    @GetMapping("/produtoVendas")
    public List<ProdutoVenda>Get(){

        ProdutoRdn rdn = new ProdutoRdn();
        return rdn.obterTodos();
    }

    @GetMapping("/produtoVenda/{id}")
    public ProdutoVenda GetById(@PathVariable("id")int id){

        ProdutoRdn rdn = new ProdutoRdn();
        return rdn.obterPorId(id);
    }

    @PostMapping("/produtoVenda")
    public int Post(@RequestBody ProdutoVenda produtoVenda)
    {
        ProdutoRdn rdn = new ProdutoRdn();
        return rdn.inserirProduto(produtoVenda);
    }
    
    @PutMapping("/produtoVenda/{id}")
    public int put(@PathVariable("id")int id, @RequestBody ProdutoVenda produtoVenda) 
    {
        ProdutoRdn rdn = new ProdutoRdn();
        int retorno = 0;

        if(rdn.obterPorId(id).getId() > 0)
        {
            retorno = rdn.alterarProduto(produtoVenda);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }

        return retorno;
    }


    @DeleteMapping("/produtoVendass/{id}")
    public int delete(@PathVariable("id")int id ) 
    {
        ProdutoRdn rdn = new ProdutoRdn();
        int retorno = 0;

            retorno = rdn.deletarProduto(id);

        return retorno;
    }
    
}
