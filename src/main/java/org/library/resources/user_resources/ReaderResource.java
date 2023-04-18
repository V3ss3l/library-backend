package org.library.resources.user_resources;

import org.library.tdo.user_tdo.Formuliar;
import org.library.tdo.user_tdo.Reader;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Path("/reader")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReaderResource {
    @GET
    public Response getAll(){
        List<Reader> list = Reader.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return Reader.findByIdOptional(id)
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
    public Response create(Reader result) {
        result.setRegistrationDate(new Date(LocalDate.now().toEpochSecond(LocalTime.now(), (ZoneOffset) ZoneOffset.systemDefault())));
        Formuliar.persist(result);
        if(result.isPersistent()){
            return Response.created(URI.create("/reader" + result.id)).build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = Formuliar.deleteById(id);
        if(deleted) {
            return Response.noContent().build();
        } else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
