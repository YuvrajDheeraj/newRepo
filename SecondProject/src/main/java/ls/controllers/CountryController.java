package ls.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ls.models.Country;
import ls.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryservice;
	
	

	@RequestMapping ("country")
	public String getCountries(Model model) {
		List<Country> CountryList=countryservice.getCountries();
		model.addAttribute("countries", CountryList);
		return "Country";
	}
	
	@PostMapping("countries/addNew")
	public String addNew(Country country) {
		countryservice.save(country);
		return "redirect:/country";
	}
	
	
//	@RequestMapping("countries/findById/{id}")
//	public String updateCountry(Model model,RedirectAttributes rd,@PathVariable("id") int id) {
//		Optional<Country> country=countryservice.findById(id);
//		model.addAttribute("count", country);
//		return "Country";
//		
//	}
	
	@RequestMapping("countries/findById")
	@ResponseBody
	public Optional<Country> findById(int id) {
		return countryservice.findById(id);
	}
	
	@RequestMapping(value="/countries/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Country country) {
		countryservice.save(country);
		return "redirect:/country";
	}
	

//	@RequestMapping(value="/countries/update",method= {RequestMethod.PUT,RequestMethod.GET})
//	public String update(Integer id, String capital, String description) {
//		countryservice.update(id,  capital, description);
//		return "redirect:/country";
//	}
//	
	
	
	@RequestMapping (value="/countries/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		countryservice.delete(id);
		return "redirect:/country";
	}
	
}
