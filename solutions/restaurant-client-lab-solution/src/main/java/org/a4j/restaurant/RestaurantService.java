package org.a4j.restaurant;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * TODO: Configure this interface to make it a RestClient. To do so,
 * add the @Path annotation pointing to the path of the API it should consume, "restaurants".
 * Also, make sure to add the @RegisterRestClient annotation
 */
@Path("restaurants")
@RegisterRestClient
public interface RestaurantService {
    //TODO: Implement getAll()
    @GET
    Collection<Item> getAll();

    //TODO: Implement findById();
    @GET
    @Path("{id}")
    Item findById(@PathParam("id") String id);

    //TODO: Implement insert();
    @POST
    public Response insert(Item item);

    //TODO: Implement update();
    @PUT
    @Path("{id}")
    Item update(@PathParam("id") String id, @Valid Item item);

    //TODO: Implement delete();
    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") String id);
}
