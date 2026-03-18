package org.softsofi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.softsofi.dto.CustomerRequestDTO;
import org.softsofi.dto.CustomerResponceDTO;
import org.softsofi.entities.Customer;
import org.softsofi.exeception.CustomerNotFoundExeception;
import org.softsofi.mapper.CustomerMapper;
import org.softsofi.repositories.CustomerRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@ApplicationScoped
@Transactional
@AllArgsConstructor


public class CustomerServiceImp implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
   

    @Override
    public CustomerResponceDTO save(CustomerRequestDTO customerRequestDTO) {
      Customer customer = customerMapper.toCustomer(customerRequestDTO);
      customerRepository.persist(customer);
      return customerMapper.toCustomerResponceDTO(customer);
    }

    @Override
    public CustomerResponceDTO getCustomer(Long id) throws CustomerNotFoundExeception {
          Customer customer = customerRepository.findById(id);
          if(customer == null){
            throw new CustomerNotFoundExeception("Customer not found");
          }
          return customerMapper.toCustomerResponceDTO(customer);
          
    }

    @Override
    public List<CustomerResponceDTO> getAllCustomers() {
        List<CustomerResponceDTO> customers = customerRepository.listAll()
        .stream()
        .map(customerMapper::toCustomerResponceDTO)
        .collect(Collectors.toList());
        return customers;
    }

    @Override
    public CustomerResponceDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) throws CustomerNotFoundExeception {
        Customer customer = customerRepository.findById(id);
        if(customer == null){
            throw new CustomerNotFoundExeception("Customer not found");
        }
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customerRequestDTO.getEmail());
        customerRepository.persist(customer);
        return customerMapper.toCustomerResponceDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id) throws CustomerNotFoundExeception {
        Customer customer = customerRepository.findById(id);
        if(customer == null){
            throw new CustomerNotFoundExeception("Customer not found");
        }
       customerRepository.deleteById(id);
    }

}
