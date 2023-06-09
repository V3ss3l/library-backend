package org.library.resources.user_resources;

import org.library.tdo.book_tdo.Book;
import org.library.tdo.book_tdo.BookDelivery;
import org.library.tdo.user_tdo.Formuliar;
import org.library.tdo.LoginInfo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/formuliar")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FormuliarResource {
    @GET
    public Response getAll(){
        List<Formuliar> list = Formuliar.listAll();
        return Response.ok(list).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        return Formuliar.findByIdOptional(id)
                .map(result -> Response.ok(result).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("{id}/orders")
    public Response getOrdersByFormuliar(@PathParam("id") Long id){
        List<BookDelivery> list = BookDelivery.getListOfOrders(id);
        if (list.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
        else return Response.ok(list).build();
    }

    @POST
    @Path("login")
    public Response login(LoginInfo info){
        var result = Formuliar.findReaderByLoginInfo(info.getEmail(), info.getPassword());
        if(result == null) return Response.status(Response.Status.NOT_FOUND).build();
        else return Response.ok(result).build();
    }

    @POST
    @Transactional
    public Response create(Formuliar result) {
        result.persistAndFlush();
        if(result.isPersistent()){
            return Response.created(URI.create("/formuliar" + result.getId())).build();
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
