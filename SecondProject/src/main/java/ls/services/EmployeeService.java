package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.Employee;
import ls.repositories.EmployeeRepository;

@Service 
public class EmployeeService {
	
	@Autowired  private EmployeeRepository employeerepository;
	
	public List<Employee> getEmployee(){
		return employeerepository.findAll();
	}
	
	
	public void save(Employee employee) {
		employeerepository.save(employee);
	}
	
	public Optional<Employee>  findById(int id) {
		return employeerepository.findById(id);
		
	}

	public void delete(int id) {
		employeerepository.deleteById(id);
	}


}
