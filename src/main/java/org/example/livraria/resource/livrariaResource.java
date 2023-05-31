package org.example.livraria.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.livraria.entity.livrariaEntity;
import org.example.livraria.request.livrariaRequest;
import org.example.livraria.response.livrariaResponse;
import org.example.livraria.service.livrariaService;

import java.util.List;

@Path("/v1/resource")
public class livrariaResource {

    private livrariaService livrosService = new livrariaService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        return Response.ok(new String("Got it!")).build();
    }



    @POST
    @Path("/livraria/Livros")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postLivros(livrariaRequest livrariaRequest) {
        livrosService.postLivros(livrariaRequest);
        return Response.ok().build();
    }
    @DELETE
    @Path("/livraria/Livros/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteLivros(@PathParam("id") int id,livrariaRequest livrariaRequest) {
        livrosService.deleteLivros(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/livraria/Livros/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putLivros(@PathParam("id") int id,livrariaRequest livroRequest) {
        livrosService.putLivros(id, livroRequest);
        return Response.ok().build();
    }

    @GET
    @Path("/livraria/Livros")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response returnLivros() {
        List<livrariaEntity> livros = livrosService.returnLivros();
        System.out.println(livros);
        return Response.ok(livros, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/livraria/Livros/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response returnLivrosByID(@PathParam("id") int id) {
        List<livrariaEntity> livros = livrosService.returnLivros();
        return Response.ok(livros, MediaType.APPLICATION_JSON).build();
    }


    @GET
    @Path("/livraria")
    @Produces(MediaType.APPLICATION_JSON)
    public Response livraria() {
        livrariaResponse message = new livrariaResponse();
        message.setTitulo("Bem-vindo à Livraria X");
        return Response.ok(message).build();
    }
}
