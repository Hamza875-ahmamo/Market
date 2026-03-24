    
package org.softsofi.controllers;
import java.util.List;
import org.softsofi.dto.CustomerCreateDTO;
import org.softsofi.dto.CustomerUpdateDTO;
import org.softsofi.dto.CustomerResponseDTO;
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
    public CustomerResponseDTO getCustomer(@PathParam("id") Long id) throws CustomerNotFoundExeception {
        return customerService.getCustomer(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponseDTO save(CustomerCreateDTO createDTO) {
        return customerService.save(createDTO);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponseDTO updateCustomer(@PathParam("id") Long id, CustomerUpdateDTO updateDTO) throws CustomerNotFoundExeception {
        return customerService.updateCustomer(id, updateDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") Long id) throws CustomerNotFoundExeception {
        customerService.deleteCustomer(id);
    }
}
