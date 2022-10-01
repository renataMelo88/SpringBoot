package com.projeto.sptech.exercicioswagger01;

public class Produto {
     private String nome;
     private double precoUnitario;
     private double quantidadeEstoque;

    public Produto(String nome, double precoUnitario, double quantidadeEstoque) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

   public double getValorEstoque(){
        return getQuantidadeEstoque() * getPrecoUnitario();
   }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
