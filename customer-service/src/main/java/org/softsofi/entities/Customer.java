package org.softsofi.entities;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers", indexes = {
    @Index(name = "idx_customer_email", columnList = "c_email", unique = true),
    @Index(name = "idx_customer_name", columnList = "c_name")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "c_name", nullable = false, length = 100)
    public String name;

    @Column(name = "c_email", nullable = false, length = 100, unique = true)
    public String email;

    @Column(name = "created_at", nullable = false)
    public LocalDate createdAt = LocalDate.now();
}
