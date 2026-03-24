package org.softsofi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.softsofi.dto.InvoiceCreateDTO;
import org.softsofi.dto.InvoiceUpdateDTO;
import org.softsofi.dto.InvoiceResponseDTO;
import org.softsofi.entities.Invoice;

@Mapper(componentModel = "jakarta")
public interface InvoiceMapper {
    InvoiceResponseDTO toInvoiceResponseDTO(Invoice invoice);
    Invoice toInvoice(InvoiceCreateDTO dto);
    void updateInvoiceFromDto(InvoiceUpdateDTO dto, @MappingTarget Invoice entity);
}
