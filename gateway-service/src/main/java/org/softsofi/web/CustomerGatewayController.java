package org.softsofi.web;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.softsofi.client.CustomerProxyClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerGatewayController {

    @Inject
    @RestClient
    CustomerProxyClient customerProxyClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getAllCustomers() {
        return customerProxyClient.getAllCustomers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getCustomerById(@PathParam("id") Long id) {
        return customerProxyClient.getCustomerById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object saveCustomer(Object customer) {
        return customerProxyClient.saveCustomer(customer);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object updateCustomer(@PathParam("id") Long id, Object customer) {
        return customerProxyClient.updateCustomer(id, customer);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") Long id) {
        customerProxyClient.deleteCustomer(id);
    }
}
