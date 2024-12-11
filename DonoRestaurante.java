
package com.mycompany.ifoodd.java;
public class DonoRestaurante extends Usuario {
    private Restaurante restaurante;

    public DonoRestaurante(int identificacao, String nome, String email, String senha) {
        super(identificacao, nome, email, senha);
    }

    public void adicionarProduto(Produto produto) {
        if (restaurante == null) {
            System.out.println("Nenhum restaurante foi cadastrado. Não é possível adicionar produtos.");
            return;
        }
        restaurante.listarProdutos().add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado ao restaurante.");
    }

    public void removerProduto(int produtoIdentificacao) {
        if (restaurante == null) {
            System.out.println("Nenhum restaurante foi cadastrado. Não é possível remover produtos.");
            return;
        }
        restaurante.listarProdutos().removeIf(p -> p.getIdentificacao() == produtoIdentificacao);
        System.out.println("Produto removido com sucesso.");
    }
    @Override
    public void login() {
        System.out.println("Dono do restaurante " + super.getNome() + " logado com sucesso!");
    }
    @Override 
    public void cadastro() {
        System.out.println("Cadastro realizado para o dono do restaurante: " + super.getNome());
    }

    public void cadastrarRestaurante(String nome, String endereco) {
        this.restaurante = new Restaurante(nome, endereco);
        System.out.println("Restaurante cadastrado com sucesso: " + nome);
    }

    public void cadastrarProduto(Produto produto) {
        adicionarProduto(produto);
    }

    public void salvarAlteracoes() {
        System.out.println("Alterações salvas no sistema.");
    }
}
