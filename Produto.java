package com.mycompany.ifoodd.java;
public abstract class Produto {
    private int identificacao;
    private String nome;
    private String descricao;
    private double preco;
    private int tempoPreparo;

    public Produto(int identificacao, String nome, String descricao, double preco, int tempoPreparo) {
        this.identificacao = identificacao;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tempoPreparo = tempoPreparo;
    }

    public int getIdentificacao() {
        return identificacao;
    }
    public void setIdentificacao(int identificacao){
        this.identificacao = identificacao;
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
    public String getDescricao(){
        return descricao;
    }
    public void setDescricacao(String descricao){
        if(descricao.length() > 0){
            this.descricao = descricao;
        } else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }
    }
     public double getPreco(){
        return preco;
    }
    public void setPreco (double preco){
        if(preco > 0){
            this.preco = preco;
        } else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }
    }
     public int getTempoPreparo(){
        return tempoPreparo;
    }
    public void setTempoPreparo(int tempoPreparo){
        if(tempoPreparo > 0){
            this.tempoPreparo = tempoPreparo;
        } else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }
    }
    

    public abstract void exibirDetalhes();
}
