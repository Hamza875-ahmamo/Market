package org.softsofi.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/customers")
@RegisterRestClient(configKey = "customer-api")
public interface CustomerProxyClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Object> getAllCustomers();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Object getCustomerById(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Object saveCustomer(Object customer);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Object updateCustomer(@PathParam("id") Long id, Object customer);

    @DELETE
    @Path("/{id}")
    void deleteCustomer(@PathParam("id") Long id);
}
