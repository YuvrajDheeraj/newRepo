package ls.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.VehicleType;
import ls.services.CountryService;
import ls.services.VehicleTypeService;
import ls.services.StateService;

@Controller 
public class VehicleTypeController {
	@Autowired private VehicleTypeService vehicletypeservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	

	
	@RequestMapping("vehicleType")
	public String getVehicleType(Model model){
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		model.addAttribute("vehicletype", vehicletypeservice.getVehicleType());
		return "vehicleType";
	}
	
	@RequestMapping("vehicleType/addNew")
	public String save(VehicleType vehicletype) {
		vehicletypeservice.save(vehicletype);
		return "redirect:/vehicleType";
	}

	@PostMapping("vehicleType/update")
	public String update(VehicleType vehicletype) {
		vehicletypeservice.save(vehicletype);
		return "redirect:/vehicleType";
	}
	
	@RequestMapping("vehicleType/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id){
		return vehicletypeservice.findById(id);
	}
	
	@RequestMapping(value="vehicleType/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehicletypeservice.delete(id);
		return "redirect:/vehicleType";
	}

}
