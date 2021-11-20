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

import ls.models.Vehicle;
import ls.services.VehicleService;
import ls.services.VehicleStatusService;
import ls.services.VehicleTypeService;
import ls.services.CountryService;
import ls.services.EmployeeService;
import ls.services.LocationService;
import ls.services.StateService;
import ls.services.VehicleMakeService;
import ls.services.VehicleModelService;

@Controller 
public class VehicleController {	
	
	@Autowired private VehicleService vehicleservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	@Autowired private VehicleTypeService vehicleType;
	@Autowired private VehicleMakeService vehicleMake;
	@Autowired private VehicleModelService vehicleModel;
	@Autowired private LocationService location;
	@Autowired private EmployeeService employee;
	@Autowired private VehicleStatusService vehicleStatus;
	
	
	@RequestMapping ("vehicle")
	public String getVehicle(Model model) {
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		List<Vehicle> VehicleList=vehicleservice.getVehicle();
		model.addAttribute("vehicle", VehicleList);
		model.addAttribute("vehicleType",vehicleType.getVehicleType());
		model.addAttribute("vehicleMake",vehicleMake.getVehicleMake());
		model.addAttribute("vehicleModel",vehicleModel.getVehicleModel());
		model.addAttribute("location",location.getLocation());
		model.addAttribute("employee",employee.getEmployee());
		model.addAttribute("vehicleStatus",vehicleStatus.getVehicleStatus());
	
		return "vehicle";
	}
	
	@PostMapping("Vehicle/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleservice.save(vehicle);
		return "redirect:/vehicle";
	}
	
	
	@RequestMapping("Vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id) {
		return vehicleservice.findById(id);
	}
	
	@RequestMapping(value="/Vehicle/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleservice.save(vehicle);
		return "redirect:/vehicle";
	}
	

	
	@RequestMapping (value="/Vehicle/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehicleservice.delete(id);
		return "redirect:/vehicle";
	}
	

}
