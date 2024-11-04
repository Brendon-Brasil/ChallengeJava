package br.com.fiap.service;

import br.com.fiap.domain.RepositorioCarros;
import br.com.fiap.domain.RepositorioClientes;
import br.com.fiap.domain.model.Carro;

import java.util.List;

public class CarroService {
    private RepositorioCarros repositorioCarros;
    private RepositorioClientes repositorioClientes;

    public CarroService(RepositorioCarros repositorioCarros, RepositorioClientes repositorioClientes) {
        this.repositorioCarros = repositorioCarros;
        this.repositorioClientes = repositorioClientes;
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
        repositorioClientes.fecharConexao();
    }

    public List<Carro> pegarCarrosDoUsuario(String email) {
        Long idCliente = repositorioClientes.retornarIdPorEmail(email);
        List<Carro> carros = repositorioCarros.pegarCarrosDoUsuario(idCliente);

        repositorioCarros.fecharConexao();
        repositorioClientes.fecharConexao();

        return carros;
    }
}
