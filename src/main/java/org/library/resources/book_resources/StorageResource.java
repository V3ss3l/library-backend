package org.library.resources.book_resources;

import org.library.tdo.book_tdo.Book;
import org.library.tdo.book_tdo.Storage;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/storage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StorageResource {
    @GET
    public Response getAll(){
        List<Storage> list = Storage.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return Storage.findByIdOptional(id)
                .map(result -> Response.ok(result).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /*@GET
    @Path("{group_name}")
    public Response searchByName(String name){
        Adress buff = Adress.findByStreet(name);
        if(buff == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else return Response.ok(buff).build();
    }*/

    @POST
    @Transactional
    public Response create(Storage result) {
        result.persistAndFlush();
        if(result.isPersistent()){
            return Response.created(URI.create("/storage" + result.id)).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = Storage.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
