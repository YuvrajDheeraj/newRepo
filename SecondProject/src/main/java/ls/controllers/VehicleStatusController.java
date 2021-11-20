package ls.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.VehicleStatus;
import ls.services.CountryService;
import ls.services.VehicleStatusService;
import ls.services.StateService;

@Controller 
public class VehicleStatusController {
	@Autowired private VehicleStatusService vehiclestatusservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	

	
	@RequestMapping("vehicleStatus")
	public String getVehicleStatus(Model model){
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		model.addAttribute("vehiclestatus", vehiclestatusservice.getVehicleStatus());
		return "vehicleStatus";
	}
	
	@RequestMapping("vehicleStatus/addNew")
	public String save(VehicleStatus vehiclestatus) {
		vehiclestatusservice.save(vehiclestatus);
		return "redirect:/vehicleStatus";
	}

	@PostMapping("vehicleStatus/update")
	public String update(VehicleStatus vehiclestatus) {
		vehiclestatusservice.save(vehiclestatus);
		return "redirect:/vehicleStatus";
	}
	
	@RequestMapping("vehicleStatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id){
		return vehiclestatusservice.findById(id);
	}
	
	@RequestMapping(value="vehicleStatus/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehiclestatusservice.delete(id);
		return "redirect:/vehicleStatus";
	}

}
