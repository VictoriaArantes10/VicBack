package com.reges.regesspring.models;

public class ProdutoVenda extends Produto {
    
    private String cartaoFidelidade;

    public ProdutoVenda(int id, String nome, String codigoBarras, String valor, String fornecedor, String grupo) {
        
        super(id, nome, codigoBarras, valor, fornecedor,grupo, "as");
    }
    

    public String getCartaoFidelidade() {
        return cartaoFidelidade;
    }

    public void setCartaoFidelidade(String cartaoFidelidade) {
        this.cartaoFidelidade = cartaoFidelidade;
    }

}
