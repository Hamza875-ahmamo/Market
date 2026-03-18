package org.softsofi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.softsofi.dto.CustomerRequestDTO;
import org.softsofi.dto.CustomerResponceDTO;
import org.softsofi.entities.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface CustomerMapper {
   Customer toCustomer(CustomerRequestDTO customerRequestDTO);
   CustomerResponceDTO toCustomerResponceDTO(Customer customer);
  
}
