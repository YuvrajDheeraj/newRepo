package ls.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.EmployeeType;
import ls.services.CountryService;
import ls.services.EmployeeTypeService;
import ls.services.StateService;

@Controller
public class EmployeeTypeController {

	@Autowired private EmployeeTypeService employeetypeservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	

	
	@RequestMapping("employeeType")
	public String getEmployeeType(Model model){
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		model.addAttribute("employeetype", employeetypeservice.getEmployeeType());
		return "employeeType";
	}
	
	@RequestMapping("employeeType/addNew")
	public String save(EmployeeType employeetype) {
		employeetypeservice.save(employeetype);
		return "redirect:/employeeType";
	}

	@PostMapping("employeeType/update")
	public String update(EmployeeType employeetype) {
		employeetypeservice.save(employeetype);
		return "redirect:/employeeType";
	}
	
	@RequestMapping("employeeType/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id){
		return employeetypeservice.findById(id);
	}
	
	@RequestMapping(value="employeeType/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		employeetypeservice.delete(id);
		return "redirect:/employeeType";
	}
}
