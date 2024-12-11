package com.mycompany.ifoodd.java;
  public class Comida extends Produto {
    private String tipoCozinha;
    private String tipoPrato;
    

    public Comida(int identificacao, String nome, String descricao, double preco, int tempoPreparo, String tipoCozinha, String tipoPrato) {
        super(identificacao, nome, descricao, preco, tempoPreparo);
        this.tipoCozinha = tipoCozinha;
        this.tipoPrato = tipoPrato;
       
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Comida: " + getNome() + " | Tipo de cozinha: " + tipoCozinha + 
                           " | Tipo de Prato: "+ tipoPrato);
    }
    public String getTipoCozinha(){
        return tipoCozinha;
        
    }
    public void setTipoCozinha(String tipoCozinha){
        if(tipoCozinha.length()>0){
            this.tipoCozinha = tipoCozinha;
        } 
    }
    public String getTipoPrato(){
        return tipoPrato;
        
    }
    public void setTipoPrato(String tipoPrato){
        if(tipoPrato.length()>0){
            this.tipoPrato = tipoPrato;
        }
        
    }
   }
 

