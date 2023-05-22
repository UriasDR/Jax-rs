package org.example.livraria.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.livraria.request.livrariaRequest;
import org.example.livraria.response.livrariaResponse;
import org.example.livraria.service.livrariaService;

@Path("/v1/resource")
public class livrariaResource {

    private livrariaService livrosService = new livrariaService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        return Response.ok(new String("Got it!")).build();
    }

    @POST
    @Path("/livraria")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(livrariaRequest livrariaRequest) {
        String livrosResponse = livrosService.returnLivros(livrariaRequest.getTitulo());
        return Response.ok(livrosResponse).build();
    }

    @POST
    @Path("/livraria/Livros")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postLivros(livrariaRequest livrariaRequest) {
        livrosService.postLivros(livrariaRequest);
        return Response.ok().build();
    }

    @GET
    @Path("/livraria/Titulo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTitulos() {
        return Response.ok(livrosService.getTitulos()).build();
    }


    @GET
    @Path("/livraria")
    @Produces(MediaType.APPLICATION_JSON)
    public Response livraria() {
        livrariaResponse message = new livrariaResponse();
        message.setTitulo("Título do Livro");
        return Response.ok(message).build();
    }
}
