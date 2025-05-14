package br.com.vendas.service;

import br.com.vendas.model.Cliente;
import br.com.vendas.model.Produto;
import br.com.vendas.model.Venda;
import br.com.vendas.util.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

public class VendaService {
    private final List<Venda> vendas = new ArrayList<>();

    public void registrarVenda(Cliente cliente, List<Produto> produtos, List<Integer> quantidades) {
        if (produtos.size() != quantidades.size()) {
            System.out.println("❌ Erro: número de produtos e quantidades não correspondem.");
            return;
        }

        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            int qtd = quantidades.get(i);
            if (!p.temEstoque(qtd)) {
                System.out.println("❌ Produto sem estoque suficiente: " + p.getNome());
                return;
            }
        }

        for (int i = 0; i < produtos.size(); i++) {
            produtos.get(i).reduzirEstoque(quantidades.get(i));
        }


        Venda venda = new Venda(cliente, produtos, quantidades);
        vendas.add(venda);

        System.out.println("🛒 Venda registrada com sucesso!\n" + venda);


        ArquivoUtil.registrar("vendas.txt", gerarResumoVenda(cliente, produtos, quantidades));
    }

    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda v : vendas) {
                System.out.println(v);
                System.out.println("-----------------------------");
            }
        }
    }

    private String gerarResumoVenda(Cliente cliente, List<Produto> produtos, List<Integer> quantidades) {
        StringBuilder sb = new StringBuilder();
        sb.append("Venda registrada:\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Produtos:\n");
        for (int i = 0; i < produtos.size(); i++) {
            sb.append("- ")
                    .append(produtos.get(i).getNome())
                    .append(" | Qtd: ").append(quantidades.get(i))
                    .append("\n");
        }
        return sb.toString();
    }
}
