package com.mycompany.ifoodd.java;
import java.util.List;
import java.util.ArrayList;
public class Pedido {
    private int identificacao;
    private List<Produto> produtos;
    private double valorTotal;
    private int tempoEstimado;
    private Cliente cliente;

    public Pedido(int identificacao, Cliente cliente) {
        this.identificacao = identificacao;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
 
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        valorTotal += produto.getPreco();
        tempoEstimado += produto.getTempoPreparo();
    }

    public void removerProduto(int produtoIdentificacao) {
        produtos.removeIf(p -> p.getIdentificacao() == produtoIdentificacao);
        System.out.println("Produto removido do pedido.");
    }

    public void calcularPrecoETempo(List<Produto> produtos) {
    double total = 0;
    int tempo = 0;

    for (Produto produto : produtos) {
        total += produto.getPreco();
        tempo += produto.getTempoPreparo();
    }

    System.out.println("Total do pedido: R$" + total);
    System.out.println("Tempo estimado: " + tempo + " minutos.");
}
    public int getIdentificacao(){
        return identificacao;
    }
    public void setIdentificacao(int identificacao){
        this.identificacao = identificacao;
        
    }
    public List<Produto> listarProdutos() {
        return produtos;
    }
    public void setListProduto(ArrayList<Produto> produtos) {
    this.produtos = produtos;
}
   public Cliente getCliente(){
       return cliente;
   }
   public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
