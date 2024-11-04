package br.com.fiap.controller;

import br.com.fiap.domain.model.Login;
import br.com.fiap.infra.dao.ClienteDAO;
import br.com.fiap.domain.model.Cliente;
import br.com.fiap.infra.dao.LoginDAO;
import br.com.fiap.service.ClienteService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController() {
        this.clienteService = new ClienteService(new ClienteDAO(), new LoginDAO());
    }

    @POST
    @Path("/cadastro")
    public Response salvarCliente(Cliente cliente) {
        try {
            clienteService.salvarCliente(cliente);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    public Response fazerLogin(Login login) {
        try {
            Login loginPego = clienteService.fazerLogin(login);
            return Response.status(Response.Status.OK).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
    }
}
