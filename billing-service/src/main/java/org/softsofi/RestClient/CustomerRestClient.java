package org.softsofi.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

import javax.annotation.processing.Generated;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.softsofi.entities.Customer;

@Path("/customers")
@RegisterRestClient(configKey = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GET
    @Path("/{id}")
    Customer getCustomerById(@PathParam("id") Long id);
    @GET
    List<Customer> getAllCustomers();

}
