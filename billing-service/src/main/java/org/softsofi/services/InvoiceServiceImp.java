package org.softsofi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.softsofi.dto.InvoiceCreateDTO;
import org.softsofi.dto.InvoiceUpdateDTO;
import org.softsofi.dto.InvoiceResponseDTO;
import org.softsofi.entities.Customer;
import org.softsofi.entities.Invoice;
import org.softsofi.exeception.CustomerNotFoundExeception;
import org.softsofi.exeception.InvoiceNotFoundExeception;
import org.softsofi.mapper.InvoiceMapper;
import org.softsofi.repositories.InvoiceRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.softsofi.RestClient.CustomerRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InvoiceServiceImp implements InvoiceService {

    private CustomerRestClient customerRestClient;
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;

    @Inject
    public InvoiceServiceImp(@RestClient CustomerRestClient customerRestClient, InvoiceRepository invoiceRepository,
            InvoiceMapper invoiceMapper) {
        this.customerRestClient = customerRestClient;
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.listAll();
        return invoices.stream().map(invoice -> {
            try {
                Customer customer = customerRestClient.getCustomerById(invoice.getCustomerId());
                invoice.setCustomer(customer);
            } catch (Exception e) {
                   throw new CustomerNotFoundExeception("Customer not found");
            }
            return invoiceMapper.toInvoiceResponseDTO(invoice);
        }).collect(Collectors.toList());
    }

    @Override
    public InvoiceResponseDTO save(InvoiceCreateDTO createDTO) {
        Invoice invoice = invoiceMapper.toInvoice(createDTO);
        invoiceRepository.persist(invoice);
        
        // Fetch the customer using the REST client
        try {
            Customer customer = customerRestClient.getCustomerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        } catch (Exception e) {
            // Handle if customer not found
            throw new CustomerNotFoundExeception("Customer not found for ID: " + invoice.getCustomerId() + " | Cause: " + e.getMessage());
        }

        return invoiceMapper.toInvoiceResponseDTO(invoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(Long id) throws InvoiceNotFoundExeception, CustomerNotFoundExeception {
        Invoice invoice = invoiceRepository.findById(id);
        if (invoice == null) {
            throw new InvoiceNotFoundExeception("Invoice not found");
        }
        Customer customer = customerRestClient.getCustomerById(invoice.getCustomerId());
        if (customer == null) {
            throw new CustomerNotFoundExeception("Customer not found");
        }
        invoice.setCustomer(customer);
        return invoiceMapper.toInvoiceResponseDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(Long customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
        return invoices.stream().map(
            invoice -> {
                try {
                    Customer customer = customerRestClient.getCustomerById(invoice.getCustomerId());
                    invoice.setCustomer(customer);
                } catch (Exception e) {
                    throw new CustomerNotFoundExeception("Customer not found");
                }
                return invoiceMapper.toInvoiceResponseDTO(invoice);
            }).collect(Collectors.toList());
    }

    @Override
    public InvoiceResponseDTO updateInvoice(Long id, InvoiceUpdateDTO updateDTO) throws InvoiceNotFoundExeception, CustomerNotFoundExeception {
        Invoice invoice = invoiceRepository.findById(id);
        if (invoice == null) {
            throw new InvoiceNotFoundExeception("Invoice not found");
        }
        
        invoiceMapper.updateInvoiceFromDto(updateDTO, invoice);
        invoiceRepository.persist(invoice);
        
        try {
            Customer customer = customerRestClient.getCustomerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        } catch (Exception e) {
            throw new CustomerNotFoundExeception("Customer not found for ID: " + invoice.getCustomerId() + " | Cause: " + e.getMessage());
        }

        return invoiceMapper.toInvoiceResponseDTO(invoice);
    }
}
