package org.a4j.restaurant.client;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.logging.Logger;

@RequestScoped
@Path("items")
public class RestaurantController {

    @Inject
    private RestaurantService service;
    private static final Logger logger = Logger.getLogger(RestaurantController.class.getName());

    @GET
    public Collection<Item> getAll() {
        return null;
        //return service.getAll();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get an item by ID", description = "Retrieves an item by the ID, its name.")
    public Item findById(@PathParam("id") String id) {
        return null;
        //return service.findById(id);
    }

    @POST
    public Response insert(@RequestBody(description = "Create a new Item.",
                                        content = @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = Item.class))) @Valid Item item) {
      //  return service.insert(item);
        return null;
    }


    @PUT
    @Path("{id}")
    public Item update(@PathParam("id") String id, @RequestBody(description = "Create a new Item.",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Item.class)))  @Valid Item item) {
      //  return service.update(id, item);
        return null;
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete an item by ID", description = "Delete an item by the ID. The item id is its name.")
    public Response delete(@PathParam("id") String id){
        return null;
        //return service.delete(id);
    }

}
