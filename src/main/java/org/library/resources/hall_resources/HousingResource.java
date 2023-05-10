package org.library.resources.hall_resources;

import org.library.tdo.hall_tdo.Housing;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/housing")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HousingResource {
    @GET
    public Response getAll(){
        List<Housing> list = Housing.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return Housing.findByIdOptional(id)
                .map(result -> Response.ok(result).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Housing result) {
        result.persistAndFlush();
        if(result.isPersistent()){
            return Response.created(URI.create("/housing" + result.getId())).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = Housing.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
