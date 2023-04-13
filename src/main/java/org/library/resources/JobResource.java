package org.library.resources;

import org.library.tdo.ReaderJob;
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
       List<ReaderJob> jobList = ReaderJob.listAll();
       return Response.ok(jobList).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return ReaderJob.findByIdOptional(id)
                .map(job -> Response.ok(job).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(ReaderJob job) {
        ReaderJob.persist(job);
        if(job.isPersistent()){
            return Response.created(URI.create("/readerjob" + job.id)).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = ReaderJob.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
