 
package com.mycompany.ifoodd.java;
public abstract class Usuario {
    private int identificacao;
    private String nome;
    private String email;
    private String senha;

    public Usuario(int identificacao, String nome, String email, String senha) {
        this.identificacao = identificacao;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public abstract void login();
    public abstract void cadastro();
    
    public int getIdentificacao(){
        return identificacao;
    }
    public void setIdentificacao(int identificacao){
        this.identificacao = identificacao;
        
    }
    public String getNome(){
         return nome;
    }
    public void setNome(String nome){
        if(nome.length()> 0){
        this.nome = nome;
        } else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }  
    }
     public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        if(email.length() > 0){
        this.email = email;
        
    }else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        if(senha.length() > 0){
        this.senha = senha;
        
    } else {
            System.out.println("Nome inválido. A alteração não foi feita.");
        }
    }
    
    }


    
