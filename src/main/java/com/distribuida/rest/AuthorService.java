package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
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

import com.distribuida.model.Author;
import com.distribuida.model.Book;


@RegisterRestClient(baseUri = "http://localhost:8082/authors")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public interface AuthorService {
	
    @GET
    List<Author> list();
	
	@GET
    @Path("/{id}")
    Author getAuthor(@PathParam("id") Long id);
	
    @POST
    Response add(Author author);

    @Transactional
    @PUT
    @Path("{id}")
    Response update(@PathParam("id") Long id, Author authorToSave) ;

    @DELETE
    @Path("{id}")
    void delete(@PathParam("id") Long id) ;
    

	@GET
    @Path("{id}/books")
    List<Book> getBooksByAuthor(@PathParam("id") Long id);

}
