package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.InvoiceStatus;
import ls.repositories.InvoiceStatusRepository;

@Service 
public class InvoiceStatusService {
@Autowired InvoiceStatusRepository invoicestatusrepository;
	
	public List<InvoiceStatus> getInvoiceStatus(){
		return invoicestatusrepository.findAll();
	}
	
	public void save(InvoiceStatus invoicestatus) {
		invoicestatusrepository.save(invoicestatus);
	}

	public Optional<InvoiceStatus> findById(int id){
		return invoicestatusrepository.findById(id);
		
	}
	
	public void delete(int id) {
		invoicestatusrepository .deleteById(id);
	}
	

}
