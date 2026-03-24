package org.softsofi.services;

import java.util.List;

import org.softsofi.dto.InvoiceCreateDTO;
import org.softsofi.dto.InvoiceUpdateDTO;
import org.softsofi.dto.InvoiceResponseDTO;
import org.softsofi.exeception.CustomerNotFoundExeception;
import org.softsofi.exeception.InvoiceNotFoundExeception;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceCreateDTO createDTO);
    InvoiceResponseDTO getInvoice(Long id) throws InvoiceNotFoundExeception, CustomerNotFoundExeception;
    List<InvoiceResponseDTO> invoicesByCustomerId(Long customerId) throws CustomerNotFoundExeception;
    List<InvoiceResponseDTO> getAllInvoices();
    InvoiceResponseDTO updateInvoice(Long id, InvoiceUpdateDTO updateDTO) throws InvoiceNotFoundExeception, CustomerNotFoundExeception;
}
