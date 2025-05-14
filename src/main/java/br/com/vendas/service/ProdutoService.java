package br.com.vendas.service;

import br.com.vendas.model.Produto;
import br.com.vendas.util.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(String codigo, String nome, double preco, int quantidade) {
        Produto produto = new Produto(codigo, nome, preco, quantidade);
        produtos.add(produto);

        System.out.println("📦 Produto cadastrado com sucesso!\n" + produto);


        ArquivoUtil.registrar("produtos.txt", "Produto cadastrado: " + produto);


        ArquivoUtil.registrar("estoque.txt", "Entrada de estoque: " + quantidade + " | Produto: " + nome);
        ArquivoUtil.registrar("estoque.txt", "Estoque atualizado: " + produto);
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
