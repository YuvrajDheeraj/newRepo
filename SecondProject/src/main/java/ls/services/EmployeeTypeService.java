package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.EmployeeType;
import ls.repositories.EmployeeTypeRepository;

@Service 
public class EmployeeTypeService {
	
@Autowired EmployeeTypeRepository employeetyperepository;
	
	public List<EmployeeType> getEmployeeType(){
		return employeetyperepository.findAll();
	}
	
	public void save(EmployeeType employeetype) {
		employeetyperepository.save(employeetype);
	}

	public Optional<EmployeeType> findById(int id){
		return employeetyperepository.findById(id);
		
	}
	
	public void delete(int id) {
		employeetyperepository .deleteById(id);
	}
	

}
