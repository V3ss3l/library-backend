package org.library.resources.book_resources;

import org.library.tdo.book_tdo.Book;
import org.library.tdo.book_tdo.BookDelivery;
import org.library.tdo.book_tdo.Package;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/bookdelivery")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookDeliveryResource {
    @GET
    public Response getAll(){
        List<BookDelivery> list = BookDelivery.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return BookDelivery.findByIdOptional(id)
                .map(result -> Response.ok(result).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(BookDelivery result) {
        result.persistAndFlush();
        if(result.isPersistent()){
            return Response.created(URI.create("/bookdelivery" + result.id)).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = BookDelivery.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
