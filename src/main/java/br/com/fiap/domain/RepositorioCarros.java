package br.com.fiap.domain;

import br.com.fiap.domain.model.Carro;

public interface RepositorioCarros {
    Long obterId();
    void salvarCarro(Carro carro);
    void fecharConexao();
}
