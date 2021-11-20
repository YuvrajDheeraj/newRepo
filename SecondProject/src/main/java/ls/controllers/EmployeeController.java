package ls.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.Country;
import ls.models.Employee;
import ls.services.CountryService;
import ls.services.EmployeeService;
import ls.services.EmployeeTypeService;
import ls.services.JobTitleService;
import ls.services.StateService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private CountryService countryservice;
	@Autowired
	private StateService stateservice;
	@Autowired
	private JobTitleService jobtitleservice;
	@Autowired
	private EmployeeTypeService employeetypeservice;
	@RequestMapping ("employee")
	public String getEmployee(Model model) {
		List<Employee> EmployeeList=employeeservice.getEmployee();
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		model.addAttribute("jobtitle",jobtitleservice.getJobTitle());
		model.addAttribute("employeeType",employeetypeservice.getEmployeeType());
		
		model.addAttribute("employee", EmployeeList);
		return "employee";
	}
	
	@PostMapping("Employee/addNew")
	public String addNew(Employee employee) {
		employeeservice.save(employee);
		return "redirect:/employee";
	}
	
	
	
	@RequestMapping("Employee/findById")
	@ResponseBody
	public Optional<Employee> findById(int id) {
		return employeeservice.findById(id);
	}
	
	@RequestMapping(value="/Employee/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Employee employee) {
		employeeservice.save(employee);
		return "redirect:/employee";
	}

	
	@RequestMapping (value="/Employee/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		employeeservice.delete(id);
		return "redirect:/employee";
	}

}
