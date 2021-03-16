package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.distribuida.model.Book;

@RegisterRestClient(baseUri = "http://localhost:8082/books")
@ApplicationScoped
@Consumes("application/json")
@Produces("application/json")
public interface BookService {
	
	@GET
    @Path("{id}")
    @Produces("application/json")
    public Book getBook(@PathParam("id") Long id);

    @GET
    @Produces("application/json")
    public List<Book> list();

    @POST
    public Response add(Book book);

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Book bookSave);

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id);

}
