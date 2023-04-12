package org.library.resources;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import org.library.tdo.ReaderJob;

import javax.inject.Inject;
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

    @POST
    @Transactional
    public Response create(ReaderJob job) {
        ReaderJob.persist(job);
        if(job.isPersistent()){
            return Response.created(URI.create("/readerjob" + job.id)).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
