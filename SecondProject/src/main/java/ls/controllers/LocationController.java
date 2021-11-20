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
import ls.models.Location;
import ls.models.State;
import ls.services.CountryService;
import ls.services.LocationService;
import ls.services.StateService;

@Controller
public class LocationController {
	@Autowired private LocationService locationservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	

	@RequestMapping("location")
	public String getLocation(Model model){
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		model.addAttribute("location", locationservice.getLocation());
		return "location";
	}
	
	@RequestMapping("location/addNew")
	public String save(Location location) {
		locationservice.save(location);
		return "redirect:/location";
	}

	@PostMapping("location/update")
	public String update(Location location) {
		locationservice.save(location);
		return "redirect:/location";
	}
	
	@RequestMapping("location/findById")
	@ResponseBody
	public Optional<Location> findById(int id){
		return locationservice.findById(id);
	}
	
	@RequestMapping(value="location/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		locationservice.delete(id);
		return "redirect:/location";
	}
}
