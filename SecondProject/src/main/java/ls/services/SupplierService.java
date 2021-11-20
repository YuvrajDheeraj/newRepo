package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.Supplier;
import ls.repositories.SupplierRepository;

@Service 
public class SupplierService {
@Autowired private SupplierRepository supplierrepository;
	
	public List<Supplier> getSupplier(){
		return supplierrepository.findAll();
	}
	
	
	public void save(Supplier supplier) {
		supplierrepository.save(supplier);
	}
	
	public Optional<Supplier>  findById(int id) {
		return supplierrepository.findById(id);
		
	}

	public void delete(int id) {
		supplierrepository.deleteById(id);
	}


}
