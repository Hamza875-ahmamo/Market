package org.softsofi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.softsofi.dto.CustomerCreateDTO;
import org.softsofi.dto.CustomerUpdateDTO;
import org.softsofi.dto.CustomerResponseDTO;
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
    public CustomerResponseDTO save(CustomerCreateDTO createDTO) {
      Customer customer = customerMapper.toCustomer(createDTO);
      customerRepository.persist(customer);
      return customerMapper.toCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO getCustomer(Long id) throws CustomerNotFoundExeception {
          Customer customer = customerRepository.findById(id);
          if(customer == null){
            throw new CustomerNotFoundExeception("Customer not found");
          }
          return customerMapper.toCustomerResponseDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<CustomerResponseDTO> customers = customerRepository.listAll()
        .stream()
        .map(customerMapper::toCustomerResponseDTO)
        .collect(Collectors.toList());
        return customers;
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerUpdateDTO updateDTO) throws CustomerNotFoundExeception {
        Customer customer = customerRepository.findById(id);
        if(customer == null){
            throw new CustomerNotFoundExeception("Customer not found");
        }
        customerMapper.updateCustomerFromDto(updateDTO, customer);
        customerRepository.persist(customer);
        return customerMapper.toCustomerResponseDTO(customer);
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
