package br.com.fiap.service;

import br.com.fiap.domain.ClienteInput;
import br.com.fiap.domain.RepositorioClientes;
import br.com.fiap.domain.RepositorioLogin;
import br.com.fiap.domain.model.Cliente;
import br.com.fiap.domain.model.Login;

public class ClienteService {
    private RepositorioClientes repositorioClientes;
    private RepositorioLogin repositorioLogin;

    public ClienteService(RepositorioClientes repositorioClientes, RepositorioLogin repositorioLogin) {
        this.repositorioClientes = repositorioClientes;
        this.repositorioLogin = repositorioLogin;
    }

    public void salvarCliente(ClienteInput cliente) {

        if (cliente.getNomeCliente().length() < 3) {
            throw new RuntimeException("Nome inválido");
        }
        if (cliente.getEmailCliente().length() < 3) {
            throw new RuntimeException("Email inválido");
        }
        if (cliente.getCpfCliente().length() != 11) {
            throw new RuntimeException("CPF inválido");
        }

        repositorioClientes.salvarCliente(new Cliente(cliente.getNomeCliente(),
                cliente.getEmailCliente(), cliente.getCpfCliente()));

        Long idCliente = repositorioClientes.retornarIdPorEmail(cliente.getEmailCliente());
        repositorioLogin.salvarLogin(new Login(cliente.getEmailCliente(), cliente.getSenha()), idCliente);
        repositorioClientes.fecharConexao();
        repositorioLogin.fecharConexao();
    }

    public Login fazerLogin(Login login) {
        Login loginPego = repositorioLogin.fazerLogin(login);

        if (loginPego.getLogin().isEmpty()) throw new RuntimeException("Login não encontrado!");

        repositorioClientes.fecharConexao();
        repositorioLogin.fecharConexao();
        return loginPego;
    }
}
