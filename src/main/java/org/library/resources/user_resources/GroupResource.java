package org.library.resources.user_resources;

import org.library.tdo.hall_tdo.HallType;
import org.library.tdo.user_tdo.UniversityGroup;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/universitygroup")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupResource {
    @GET
    public Response getAll(){
        List<HallType> list = HallType.listAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return UniversityGroup.findByIdOptional(id)
                .map(group -> Response.ok(group).build())
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
    public Response create(UniversityGroup group) {
        UniversityGroup.persist(group);
        if(group.isPersistent()){
            return Response.created(URI.create("/universitygroup" + group.id)).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = UniversityGroup.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
