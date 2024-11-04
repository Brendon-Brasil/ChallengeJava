package br.com.fiap.controller;

import br.com.fiap.domain.model.Carro;
import br.com.fiap.domain.model.Cliente;
import br.com.fiap.infra.dao.CarroDAO;
import br.com.fiap.service.CarroService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

public class CarroController {
    private CarroService carroService;

    public CarroController() {
        this.carroService = new CarroService(new CarroDAO());
    }

    @POST
    public Response salvarCarro(Carro carro) {
        try {
            carroService.salvarCarro(carro);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
    }
}
