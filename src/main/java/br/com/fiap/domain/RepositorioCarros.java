package br.com.fiap.domain;

import br.com.fiap.domain.model.Carro;

import java.util.List;

public interface RepositorioCarros {
    Long obterId();
    void salvarCarro(Carro carro);
    void fecharConexao();
    List<Carro> pegarCarrosDoUsuario(Long idCliente);
}
