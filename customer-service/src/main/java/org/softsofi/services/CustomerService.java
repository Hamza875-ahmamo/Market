package org.softsofi.services;

import java.util.List;

import org.softsofi.dto.CustomerRequestDTO;
import org.softsofi.dto.CustomerResponceDTO;
import org.softsofi.exeception.CustomerNotFoundExeception;

public interface CustomerService {
    public CustomerResponceDTO save(CustomerRequestDTO customerRequestDTO);
    public CustomerResponceDTO getCustomer(Long id) throws CustomerNotFoundExeception;
    public List<CustomerResponceDTO> getAllCustomers();
    public CustomerResponceDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) throws CustomerNotFoundExeception;
    public void deleteCustomer(Long id) throws CustomerNotFoundExeception;
  
}   
