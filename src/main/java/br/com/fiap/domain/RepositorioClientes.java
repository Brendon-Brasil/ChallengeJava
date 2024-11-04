package br.com.fiap.domain;

import br.com.fiap.domain.model.Cliente;

public interface RepositorioClientes {
    Long obterId();
    void salvarCliente(Cliente cliente);
    void fecharConexao();
    Long retornarIdPorEmail(String email);

}
