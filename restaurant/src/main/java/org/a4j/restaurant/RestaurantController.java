package org.a4j.restaurant;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Collection;

@RequestScoped
@Path("restaurants")
public class RestaurantController {

    private RestaurantRepository repository;

    /**
     * @Deprecated CDI only
     */
    RestaurantController() {}

    @Inject
    RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    //TODO don't worried about pagination
    @GET
    public Collection<Item> getAll() {
        return repository.getAll();
    }

    @GET
    @Path("{id}")
    public Item findById(@PathParam("id") String id) {
        return this.repository.findById(id).orElseThrow(
                () -> new WebApplicationException("There is no item with the id " + id, Response.Status.NOT_FOUND));
    }

    @POST
    public Response insert(@Valid Item item) {
        return Response.status(Response.Status.CREATED)
                .entity(repository.save(item))
                .build();
    }

    @PUT
    @Path("{id}")
    public Item update(@PathParam("id") String id, @Valid Item item) {
        Item databaseItem = repository.findById(id)
                .orElseThrow(
                        () -> new WebApplicationException("There is no item with the id " + id, Response.Status.NOT_FOUND));
        databaseItem.update(item, repository);
        return databaseItem;
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id){
        this.repository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
