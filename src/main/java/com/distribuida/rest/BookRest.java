package com.distribuida.rest;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/books")
public class BookRest {
    @Inject private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer id){
        return bookService.findById(id);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll(){
        // dbConfig.test();
        return bookService.findAll();
    }
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book pushBook(Book book){
        return bookService.pushBook(book);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book editBook(Book book, @PathParam("id") Integer id){
        return bookService.editBook(book, id);
    }

    @DELETE
    @Path("/{id}")
    public Boolean deleteBook(@PathParam("id") Integer id){
        return bookService.deleteBook(id);
    }

}
