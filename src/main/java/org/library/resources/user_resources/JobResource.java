package org.library.resources.user_resources;

import org.library.tdo.user_tdo.ReaderJob;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;


@Path("/readerjob")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JobResource{

    @GET
    public Response getAll(){
        List<ReaderJob> list = ReaderJob.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return ReaderJob.findByIdOptional(id)
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
    public Response create(ReaderJob result) {
        ReaderJob.persist(result);
        if(result.isPersistent()){
            return Response.created(URI.create("/readerjob" + result.id)).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = ReaderJob.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
