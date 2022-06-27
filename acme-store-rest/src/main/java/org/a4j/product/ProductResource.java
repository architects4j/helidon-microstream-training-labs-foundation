package org.a4j.product;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Collection;

// Configure CDI scope ( @RequestScoped, @ApplicationScoped, etc)
// Configure resource @Path
public class ProductResource {

    private Inventory repository;

    /**
     * @Deprecated CDI only
     */
    ProductResource() {}

    @Inject
    ProductResource(Inventory repository) {
        this.repository = repository;
    }

    /**
     * * Add JAX-RS HTTP Annotation (e.g. @GET, @POST, @PUT, @DELETE ...)
     * * Add API documentation:
     * ** Versioning documentation with @Tag
     * ** Operations documentation with @Operations summary and description
     * ** API Responses documentation with @APIResponse, responseCode and decription
      */
      public Collection<Product> getAll() {
        return repository.getAll();
    }

    /**
     * * Add JAX-RS HTTP Annotation (e.g. @GET, @POST, @PUT, @DELETE ...)
     * * Add custom @Path and configure the incoming method parameter with @PathParam("id")
     * * Add schema documentation to the method incoming parameters with @Parameter
     * * Add API documentation:
     * ** Versioning documentation with @Tag
     * ** Operations documentation with @Operations summary and description
     * ** API Responses documentation with @APIResponse, responseCode and decription
     * * Return a proper HTTP Code for errors
     * * Throw WebApplicationException instead of a generic exception in case of errors;
     */
    public Product findById(String id) {
        return this.repository.findById(id).get();
    }

    /**
     * * Add JAX-RS HTTP Annotation (e.g. @GET, @POST, @PUT, @DELETE ...)
     * * Add API documentation:
     * ** Versioning documentation with @Tag
     * ** Operations documentation with @Operations summary and description
     * ** API Responses documentation with @APIResponse, responseCode and decription
     * * Add schema documentation to the method incoming parameters with @RequestBody, @Content and @Schema
     * * Add bean validation to the incoming data with @Valid
     * * Return a proper HTTP Code for errors
     */
    public Response insert(Product product) {
        repository.save(product);
        return null;
    }

    /**
     * * Add JAX-RS HTTP Annotation (e.g. @GET, @POST, @PUT, @DELETE ...)
     * * Add custom @Path and configure the incoming method parameter with @PathParam("id")
     * * Add API documentation:
     * ** Versioning documentation with @Tag
     * ** Operations documentation with @Operations summary and description
     * ** API Responses documentation with @APIResponse, responseCode and decription
     * * Add bean validation to the incoming data with @Valid
     * * Return a proper HTTP Code for errors
     */
    public Product update(@PathParam("id") String id, Product product) {
        repository.findById(id);
        repository.save(product);
        return product;
    }

    /**
     * * Add JAX-RS HTTP Annotation (e.g. @GET, @POST, @PUT, @DELETE ...)
     * * Add custom @Path and configure the incoming method parameter with @PathParam("id")
     * * Add API documentation:
     * ** Versioning documentation with @Tag
     * ** Operations documentation with @Operations summary and description
     * ** API Responses documentation with @APIResponse, responseCode and decription
     * * Return a proper HTTP Code for errors
     */
    public Response delete(@PathParam("id") String id) {
        this.repository.deleteById(id);
        return null;
    }

}
