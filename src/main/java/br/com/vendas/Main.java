package br.com.vendas;

import br.com.vendas.model.Endereco;
import br.com.vendas.model.Produto;
import br.com.vendas.service.ClienteService;
import br.com.vendas.service.ProdutoService;
import br.com.vendas.service.VendaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        VendaService vendaService = new VendaService();

        int opcao;
        do {
            System.out.println("\n📋 MENU PRINCIPAL:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Listar produtos");
            System.out.println("4 - Registrar venda");
            System.out.println("5 - Listar vendas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Rua: ");
                    String rua = sc.nextLine();
                    System.out.print("Número: ");
                    String numero = sc.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();

                    Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
                    clienteService.cadastrarCliente(nome, cpf, telefone, endereco);
                    break;

                case 2:
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nome do Produto: ");
                    String nomeProduto = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    produtoService.cadastrarProduto(codigo, nomeProduto, preco, qtd);
                    break;

                case 3:
                    produtoService.listarProdutos();
                    break;

                case 4:
                    System.out.print("Nome do Cliente: ");
                    String nomeVenda = sc.nextLine();
                    var cliente = clienteService.buscarPorNome(nomeVenda);
                    if (cliente == null) {
                        System.out.println("❌ Cliente não encontrado.");
                        break;
                    }

                    List<Produto> produtosVendidos = new ArrayList<>();
                    List<Integer> quantidades = new ArrayList<>();
                    String continuar;
                    do {
                        System.out.print("Código do produto: ");
                        String codProd = sc.nextLine();
                        Produto produto = produtoService.buscarPorCodigo(codProd);
                        if (produto != null) {
                            System.out.print("Quantidade: ");
                            int quantidade = sc.nextInt();
                            sc.nextLine();
                            produtosVendidos.add(produto);
                            quantidades.add(quantidade);
                        } else {
                            System.out.println("Produto não encontrado.");
                        }

                        System.out.print("Adicionar outro produto? (s/n): ");
                        continuar = sc.nextLine();
                    } while (continuar.equalsIgnoreCase("s"));

                    vendaService.registrarVenda(cliente, produtosVendidos, quantidades);
                    break;

                case 5:
                    vendaService.listarVendas();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
        sc.close();
    }
}
