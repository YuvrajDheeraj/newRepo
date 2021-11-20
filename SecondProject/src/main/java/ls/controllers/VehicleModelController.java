package ls.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.VehicleModel;
import ls.services.CountryService;
import ls.services.VehicleModelService;
import ls.services.StateService;

@Controller 
public class VehicleModelController {
	@Autowired private VehicleModelService vehiclemodelservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	

	
	@RequestMapping("vehicleModel")
	public String getVehicleModel(Model model){
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		model.addAttribute("vehiclemodel", vehiclemodelservice.getVehicleModel());
		return "vehicleModel";
	}
	
	@RequestMapping("vehicleModel/addNew")
	public String save(VehicleModel vehiclemodel) {
		vehiclemodelservice.save(vehiclemodel);
		return "redirect:/vehicleModel";
	}

	@PostMapping("vehicleModel/update")
	public String update(VehicleModel vehiclemodel) {
		vehiclemodelservice.save(vehiclemodel);
		return "redirect:/vehicleModel";
	}
	
	@RequestMapping("vehicleModel/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id){
		return vehiclemodelservice.findById(id);
	}
	
	@RequestMapping(value="vehicleModel/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehiclemodelservice.delete(id);
		return "redirect:/vehicleModel";
	}
}
