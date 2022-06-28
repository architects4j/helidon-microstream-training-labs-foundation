package org.a4j.product;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@RequestScoped
@Path("products")
public class ProductResource {

    // TODO: Switch the Inventory with the injection of the new ProductRepository
    private ProductMicrostreamRepository repository;

    /**
     * @Deprecated CDI only
     */
    ProductResource() {}

    // TODO: Delete unecessary injection annotation and method
    @Inject
    ProductResource(ProductMicrostreamRepository repository) {
        this.repository = repository;
    }

    @GET
    @Tag(name = "1.0")
    @Operation(summary = "List products", description = "Retrieves all available products")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @APIResponse(responseCode = "200", description = "Available products' list")
    public Collection<Product> findAll() {
        return repository.findAll();
    }


    @GET
    @Path("{id}")
    @Tag(name = "1.0")
    @Operation(summary = "Find product by id", description = "Find product with a given id")
    @APIResponse(responseCode = "200", description = "Product successfully found")
    @APIResponse(responseCode = "404", description = "Can't find a product with the given id")
    @APIResponse(responseCode = "500", description = "Internal server error")
    @APIResponse(
            description = "The product",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = Product.class)
            )
    )
    public Product findById(@Parameter(
            description = "The product name",
            required = true,
            example = "water",
            schema = @Schema(type = SchemaType.STRING)) @PathParam("id") String id) {
        return this.repository.findById(id).orElseThrow(
                () -> new WebApplicationException("Can't find product with id " + id,
                        Response.Status.NOT_FOUND));
    }

    @POST
    @Tag(name = "1.0")
    @Operation(summary = "Save product", description = "Save a new product")
    @APIResponse(responseCode = "201", description = "Product successfully saved")
    @APIResponse(responseCode = "500", description = "Internal server error")
    public Response insert(@RequestBody(
            description = "The product",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Product.class))) @Valid Product product) {
        return Response.status(Response.Status.CREATED)
                .entity(repository.save(product))
                .build();
    }

    @PUT
    @Path("{id}")
    @Tag(name = "BETA", description = "APIs currently in beta state")
    @Operation(summary = "Update product", description = "Updates existing product information for a given id")
    @APIResponse(responseCode = "200", description = "Product successfully updated")
    @APIResponse(responseCode = "404", description = "Can't find a product with the given name")
    @APIResponse(responseCode = "500", description = "Internal server error")
    public Product update(@PathParam("id") String id, @Valid Product product) {
        repository.findById(id)
                .orElseThrow(
                        () -> new WebApplicationException("There is no product with the id " + id,
                                Response.Status.NOT_FOUND));
        repository.save(product);
        return product;
    }

    @DELETE
    @Path("{id}")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @Operation(summary = "Delete product", description = "Delete product with a given id")
    @APIResponse(responseCode = "200", description = "Product successfully deleted")
    @APIResponse(responseCode = "500", description = "Internal server error")
    public Response delete(@PathParam("id") String id) {
        this.repository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
