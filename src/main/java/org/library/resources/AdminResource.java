package org.library.resources;

import org.library.tdo.Housing;
import org.library.tdo.LibraryAdmin;
import org.library.tdo.ReaderRole;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.UUID;

public class AdminResource {
    @GET
    public Response getAll(){
        List<LibraryAdmin> list = LibraryAdmin.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id")UUID id){
        return LibraryAdmin.findByIdOptional(id)
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
    public Response create(LibraryAdmin result) {
        LibraryAdmin.persist(result);
        if(result.isPersistent()){
            return Response.created(URI.create("/libraryadmin" + result.getAdminID())).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") UUID id){
        boolean deleted = LibraryAdmin.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
