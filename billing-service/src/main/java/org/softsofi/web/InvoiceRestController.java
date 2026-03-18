package org.softsofi.web;

import java.util.List;
import javax.annotation.processing.Generated;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import org.softsofi.services.InvoiceService;
import org.softsofi.dto.InvoiceResponceDto;
import org.softsofi.dto.InvoiceRequestDTO;
import org.softsofi.exeception.InvoiceNotFoundExeception;
import org.softsofi.exeception.CustomerNotFoundExeception;

@ApplicationScoped
@AllArgsConstructor
@Path("/invoices")
public class InvoiceRestController {
    InvoiceService invoiceService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public InvoiceResponceDto getInvoice(@PathParam("id") Long id) throws InvoiceNotFoundExeception, CustomerNotFoundExeception {
        return invoiceService.getInvoice(id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<InvoiceResponceDto> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
    @GET
    @Path("/customer/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InvoiceResponceDto> getInvoicesByCustomerId(@PathParam("customerId") Long customerId) throws CustomerNotFoundExeception {
        return invoiceService.invoicesByCustomerId(customerId);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InvoiceResponceDto save(InvoiceRequestDTO invoiceRequestDTO) {
        return invoiceService.save(invoiceRequestDTO);
    }

    
}
