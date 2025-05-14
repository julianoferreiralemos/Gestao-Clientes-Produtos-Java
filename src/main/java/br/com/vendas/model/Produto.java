package br.com.vendas.model;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String codigo, String nome, double preco, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void adicionarEstoque(int quantidade) {
        this.estoque += quantidade;
    }

    public boolean temEstoque(int quantidade) {
        return this.estoque >= quantidade;
    }

    public void reduzirEstoque(int quantidade) {
        if (temEstoque(quantidade)) {
            this.estoque -= quantidade;
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Produto: " + nome + " | Preço: R$" + preco + " | Estoque: " + estoque;
    }
}
