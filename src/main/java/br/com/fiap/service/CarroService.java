package br.com.fiap.service;

import br.com.fiap.domain.RepositorioCarros;
import br.com.fiap.domain.model.Carro;

public class CarroService {
    private RepositorioCarros repositorioCarros;

    public CarroService(RepositorioCarros repositorioCarros) {
        this.repositorioCarros = repositorioCarros;
    }

    public void salvarCarro(Carro carro) {

        if (carro.getAnoCarro() < 1950) {
            throw new RuntimeException("Ano do carro inválido");
        }
        if (carro.getMarcaCarro().length() < 2) {
            throw new RuntimeException("Marca do carro inválida");
        }
        if (carro.getPlacaCarro().length() != 7) {
            throw new RuntimeException("Placa do carro inválida");
        }
        if (carro.getModeloCarro().length() < 3) {
            throw new RuntimeException("Modelo do carro inválido");
        }

        repositorioCarros.salvarCarro(carro);
        repositorioCarros.fecharConexao();
    }
}
