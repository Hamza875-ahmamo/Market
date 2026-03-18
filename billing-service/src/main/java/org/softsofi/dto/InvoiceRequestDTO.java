package org.softsofi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequestDTO {
  private LocalDate date;
  private BigDecimal amount;
  private Long customerId;
}