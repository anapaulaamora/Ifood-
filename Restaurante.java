package com.mycompany.ifood.java; 
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private String endereco;
    private ArrayList<Produto> produtos;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.produtos = new ArrayList<>();
    }

public List<Produto> listarProdutos() {
        return produtos;
    }
    public void setListProduto(ArrayList<Produto> produtos) {
    this.produtos = produtos;
}
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        if(nome.length() > 0){
            this.nome = nome;
        } else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }

    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco){
        if(endereco.length() > 0){
            this.endereco = endereco;
        } else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }
    }
    
}


