package br.com.fiap.controller;

import br.com.fiap.domain.model.Carro;
import br.com.fiap.infra.dao.CarroDAO;
import br.com.fiap.infra.dao.ClienteDAO;
import br.com.fiap.service.CarroService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class CarroController {
    private CarroService carroService;

    public CarroController() {
        this.carroService = new CarroService(new CarroDAO(), new ClienteDAO());
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

    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pegarCarrosDoUsuario(@PathParam("email") String email) {
        try {
            List<Carro> carros = carroService.pegarCarrosDoUsuario(email);
            return Response.status(Response.Status.OK).entity(carros).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
    }
}
