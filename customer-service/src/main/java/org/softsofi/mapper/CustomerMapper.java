package org.softsofi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.softsofi.dto.CustomerCreateDTO;
import org.softsofi.dto.CustomerUpdateDTO;
import org.softsofi.dto.CustomerResponseDTO;
import org.softsofi.entities.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface CustomerMapper {
    Customer toCustomer(CustomerCreateDTO dto);
    void updateCustomerFromDto(CustomerUpdateDTO dto, @MappingTarget Customer entity);
    CustomerResponseDTO toCustomerResponseDTO(Customer customer);
}
