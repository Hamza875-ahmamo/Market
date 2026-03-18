    package org.softsofi.web;

import java.util.List;
import org.softsofi.dto.CustomerRequestDTO;
import org.softsofi.dto.CustomerResponceDTO;
import org.softsofi.exeception.CustomerNotFoundExeception;
import org.softsofi.services.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
@Path("/customers")
@AllArgsConstructor
public class CustomerRestApi {
    
    private CustomerService customerService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponceDTO getCustomer(@PathParam("id") Long id) throws CustomerNotFoundExeception {
        return customerService.getCustomer(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerResponceDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponceDTO save(CustomerRequestDTO customerRequestDTO) {
        return customerService.save(customerRequestDTO);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponceDTO updateCustomer(@PathParam("id") Long id, CustomerRequestDTO customerRequestDTO) throws CustomerNotFoundExeception {
        return customerService.updateCustomer(id, customerRequestDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") Long id) throws CustomerNotFoundExeception {
        customerService.deleteCustomer(id);
    }
}
