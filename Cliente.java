package com.mycompany.ifood.java; 
public class Cliente extends Usuario {

    public Cliente(int identificacao, String nome, String email, String senha) {
        super(identificacao, nome, email, senha);
    }

    @Override
    public void login() {
        System.out.println("Cliente " + super.getNome() + " logado com sucesso!");
        
    }

    @Override
    public void cadastro() {
        System.out.println("Cadastro realizado para o cliente: " + super.getNome());
    }

     public void visualizarRestaurantes(List<Restaurante> restaurantes) {
        if (restaurantes == null || restaurantes.isEmpty()) {
            System.out.println("Nenhum restaurante cadastrado.");
            return;
        }
        
        System.out.println("Lista de restaurantes cadastrados:");
        for (Restaurante restaurante : restaurantes) {
            System.out.println("- " + restaurante.getNome() + " | Endereço: " + restaurante.getEndereco());
        }
    }

    public void selecionarRestaurante() {
        System.out.println("Restaurante selecionado.");
    }

}

    

