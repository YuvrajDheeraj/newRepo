package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.Invoice;
import ls.repositories.InvoiceRepository;

@Service 
public class InvoiceService {
	
@Autowired private InvoiceRepository invoicerepository;
	
	public List<Invoice> getinvoice(){
		return invoicerepository.findAll();
	}
	
	
	public void save(Invoice invoice) {
		invoicerepository.save(invoice);
	}
	
	public Optional<Invoice>  findById(int id) {
		return invoicerepository.findById(id);
		
	}

	public void delete(int id) {
		invoicerepository .deleteById(id);
	}

}
