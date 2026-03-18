package org.softsofi.web;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.softsofi.client.InvoiceProxyClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/invoices")
public class InvoiceGatewayController {

    @Inject
    @RestClient
    InvoiceProxyClient invoiceProxyClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getAllInvoices() {
        return invoiceProxyClient.getAllInvoices();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getInvoiceById(@PathParam("id") Long id) {
        return invoiceProxyClient.getInvoiceById(id);
    }

    @GET
    @Path("/customer/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getInvoicesByCustomerId(@PathParam("customerId") Long customerId) {
        return invoiceProxyClient.getInvoicesByCustomerId(customerId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object saveInvoice(Object invoice) {
        return invoiceProxyClient.saveInvoice(invoice);
    }
}
