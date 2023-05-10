package org.library.resources.hall_resources;

import org.library.tdo.hall_tdo.LibraryAdmin;
import org.library.tdo.LoginInfo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/libraryadmin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {
    @GET
    public Response getAll(){
        List<LibraryAdmin> list = LibraryAdmin.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id")Long id){
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
            return Response.created(URI.create("/libraryadmin" + result.getId())).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("login")
    public Response login(LoginInfo info){
        var result = LibraryAdmin.findAdminByLoginInfo(info.getEmail(), info.getPassword());
        if(result == null) return Response.status(Response.Status.NOT_FOUND).build();
        else return Response.ok(result).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = LibraryAdmin.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
