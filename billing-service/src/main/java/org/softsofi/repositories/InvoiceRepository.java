package org.softsofi.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.softsofi.entities.Invoice;
import java.util.List;

@ApplicationScoped
public class InvoiceRepository implements PanacheRepositoryBase<Invoice, Long> {
    public List<Invoice> findByCustomerId(Long customerId) {
        return find("customerId", customerId).list();

    }
}
