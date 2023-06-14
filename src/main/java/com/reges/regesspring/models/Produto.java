package com.reges.regesspring.models;

public abstract class Produto {

    protected int id;
    protected String nome;
    protected String codigoBarras;
    protected String valor;
    protected String fornecedor;
    protected String grupo;
    protected String obs;


    public Produto(int id, String nome,  String codigoBarras, 
            String valor, String fornecedor, String grupo, String obs)
    {
        this.id = id;
        this.nome = nome;        
        this.codigoBarras = codigoBarras;
        this.valor = valor;
        this.fornecedor = fornecedor;
        this.grupo = grupo; 
        this.obs = obs;       
    }    
    
     public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getObs() {
        return obs;
    }
    
     
}
