package org.softsofi.controllers;

import java.util.List;
import javax.annotation.processing.Generated;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import org.softsofi.services.InvoiceService;
import org.softsofi.dto.InvoiceResponseDTO;
import org.softsofi.dto.InvoiceCreateDTO;
import org.softsofi.dto.InvoiceUpdateDTO;
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
    public InvoiceResponseDTO getInvoice(@PathParam("id") Long id) throws InvoiceNotFoundExeception, CustomerNotFoundExeception {
        return invoiceService.getInvoice(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
    
    @GET
    @Path("/customer/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InvoiceResponseDTO> getInvoicesByCustomerId(@PathParam("customerId") Long customerId) throws CustomerNotFoundExeception {
        return invoiceService.invoicesByCustomerId(customerId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InvoiceResponseDTO save(InvoiceCreateDTO createDTO) {
        return invoiceService.save(createDTO);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InvoiceResponseDTO updateInvoice(@PathParam("id") Long id, InvoiceUpdateDTO updateDTO) throws InvoiceNotFoundExeception, CustomerNotFoundExeception {
        return invoiceService.updateInvoice(id, updateDTO);
    }
}
