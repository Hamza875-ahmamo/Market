package org.softsofi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.softsofi.dto.InvoiceRequestDTO;
import org.softsofi.dto.InvoiceResponceDto;
import org.softsofi.entities.Invoice;

@Mapper(componentModel = "jakarta")
public interface InvoiceMapper {
    InvoiceResponceDto toInvoiceResponceDto(Invoice invoice);
    Invoice toInvoice(InvoiceRequestDTO invoiceRequestDTO);
}
