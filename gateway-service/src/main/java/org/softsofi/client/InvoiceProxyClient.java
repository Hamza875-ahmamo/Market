package org.softsofi.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/invoices")
@RegisterRestClient(configKey = "billing-api")
public interface InvoiceProxyClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Object> getAllInvoices();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Object getInvoiceById(@PathParam("id") Long id);

    @GET
    @Path("/customer/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Object> getInvoicesByCustomerId(@PathParam("customerId") Long customerId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Object saveInvoice(Object invoice);
}
