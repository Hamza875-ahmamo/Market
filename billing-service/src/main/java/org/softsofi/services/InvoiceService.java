package org.softsofi.services;

import java.util.List;

import org.softsofi.dto.InvoiceRequestDTO;
import org.softsofi.dto.InvoiceResponceDto;
import org.softsofi.exeception.CustomerNotFoundExeception;
import org.softsofi.exeception.InvoiceNotFoundExeception;

public interface InvoiceService {
    InvoiceResponceDto save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponceDto getInvoice(Long id) throws InvoiceNotFoundExeception, CustomerNotFoundExeception;
    List<InvoiceResponceDto> invoicesByCustomerId(Long customerId) throws CustomerNotFoundExeception;
    List<InvoiceResponceDto> getAllInvoices();
    
}
