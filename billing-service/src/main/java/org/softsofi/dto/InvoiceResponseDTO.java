package org.softsofi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.softsofi.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
    private Long id;
    private LocalDate date;
    private BigDecimal amount;
    private Customer customer;
}
