package org.softsofi.services;

import java.util.List;

import org.softsofi.dto.CustomerCreateDTO;
import org.softsofi.dto.CustomerUpdateDTO;
import org.softsofi.dto.CustomerResponseDTO;
import org.softsofi.exeception.CustomerNotFoundExeception;

public interface CustomerService {
    public CustomerResponseDTO save(CustomerCreateDTO createDTO);
    public CustomerResponseDTO getCustomer(Long id) throws CustomerNotFoundExeception;
    public List<CustomerResponseDTO> getAllCustomers();
    public CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO updateDTO) throws CustomerNotFoundExeception;
    public void deleteCustomer(Long id) throws CustomerNotFoundExeception;
}   
