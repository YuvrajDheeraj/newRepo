package ls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ls.models.Invoice;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
