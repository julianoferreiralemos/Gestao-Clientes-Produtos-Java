package br.com.vendas.model;

import java.time.LocalDateTime;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<Produto> produtos;
    private List<Integer> quantidades;
    private LocalDateTime dataHora;

    public Venda(Cliente cliente, List<Produto> produtos, List<Integer> quantidades) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.quantidades = quantidades;
        this.dataHora = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Integer> getQuantidades() {
        return quantidades;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🧾 Venda realizada em ").append(dataHora).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        for (int i = 0; i < produtos.size(); i++) {
            sb.append("- Produto: ").append(produtos.get(i).getNome())
                    .append(" | Preço: R$").append(produtos.get(i).getPreco())
                    .append(" | Quantidade: ").append(quantidades.get(i)).append("\n");
        }
        sb.append("Total: R$").append(calcularTotal());
        return sb.toString();
    }
}
