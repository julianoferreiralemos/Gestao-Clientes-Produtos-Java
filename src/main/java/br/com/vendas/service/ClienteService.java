package br.com.vendas.service;

import br.com.vendas.model.Cliente;
import br.com.vendas.model.Endereco;
import br.com.vendas.util.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf, String telefone, Endereco endereco) {
        Cliente cliente = new Cliente(nome, cpf, telefone, endereco);
        clientes.add(cliente);

        System.out.println("✅ Cliente cadastrado com sucesso!\n" + cliente);


        ArquivoUtil.registrar("clientes.txt", "Cliente cadastrado: " + cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarPorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
