package org.softsofi.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Transient;

@Entity
@Table(name = "invoices", indexes = {
    @Index(name = "idx_invoice_customer_id", columnList = "customer_id"),
    @Index(name = "idx_invoice_date", columnList = "invoice_date")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_date", nullable = false)
    private LocalDate date;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Transient
    private Customer customer;
}
