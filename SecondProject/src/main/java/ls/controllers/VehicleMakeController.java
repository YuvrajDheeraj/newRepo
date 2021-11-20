package ls.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.VehicleMake;
import ls.services.CountryService;
import ls.services.VehicleMakeService;
import ls.services.StateService;

@Controller 
public class VehicleMakeController {
	@Autowired private VehicleMakeService vehiclemakeservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	

	
	@RequestMapping("vehicleMake")
	public String getVehicleMake(Model model){
		model.addAttribute("vehiclemake", vehiclemakeservice.getVehicleMake());
		return "vehicleMake";
	}
	
	@RequestMapping("vehicleMake/addNew")
	public String save(VehicleMake vehiclemake) {
		vehiclemakeservice.save(vehiclemake);
		return "redirect:/vehicleMake";
	}

	@PostMapping("vehicleMake/update")
	public String update(VehicleMake vehiclemake) {
		vehiclemakeservice.save(vehiclemake);
		return "redirect:/vehicleMake";
	}
	
	@RequestMapping("vehicleMake/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id){
		return vehiclemakeservice.findById(id);
	}
	
	@RequestMapping(value="vehicleMake/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehiclemakeservice.delete(id);
		return "redirect:/vehicleMake";
	}

}
