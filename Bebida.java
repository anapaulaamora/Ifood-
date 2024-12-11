        package com.mycompany.ifoodd.java; 
    public class Bebida extends Produto {
    private int tamanhoML;
    private boolean alcoolica;

    public Bebida(int identificacao, String nome, String descricao, double preco, int tempoPreparo, int tamanhoML, boolean alcoolica) {
        super(identificacao, nome, descricao, preco, tempoPreparo);
        this.tamanhoML = tamanhoML;
        this.alcoolica = alcoolica;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Bebida: " + getNome() + " | Tamanho: " + tamanhoML + "ml | Alcoólica: " + alcoolica);
    }
    public int getTamanhoML(){
        return tamanhoML;
    } 
    public void setTamanhoML(int tamanhoML){
        if(tamanhoML > 0){
            this.tamanhoML = tamanhoML;
  
        } 
    }
    public boolean getAlcoolica(){
        return alcoolica;
    }
    public void setAlcoolica(boolean alcoolica){
        if(alcoolica == true ){
           this.alcoolica = alcoolica;
           System.out.println("Essa bebiba é: Caipirinha ");
        }
        else {
            System.out.println("Não é uma caipirinha");
        }
    }
    }


    
