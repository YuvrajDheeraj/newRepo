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

import ls.models.Client;
import ls.services.ClientService;
import ls.services.CountryService;
import ls.services.StateService;

@Controller 
public class ClientController {
	
	@Autowired
	private ClientService clientservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;

	@RequestMapping ("Client")
	public String getCountries(Model model) {
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		List<Client> ClientList=clientservice.getClient();
		model.addAttribute("client", ClientList);
		return "Client";
	}
	
	@PostMapping("Client/addNew")
	public String addNew(Client client) {
		clientservice.save(client);
		return "redirect:/Client";
	}
	
	
//	@RequestMapping("countries/findById/{id}")
//	public String updateCountry(Model model,RedirectAttributes rd,@PathVariable("id") int id) {
//		Optional<Country> country=countryservice.findById(id);
//		model.addAttribute("count", country);
//		return "Country";
//		
//	}
	
	@RequestMapping("Client/findById")
	@ResponseBody
	public Optional<Client> findById(int id) {
		return clientservice.findById(id);
	}
	
	@RequestMapping(value="/Client/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Client client) {
		clientservice.save(client);
		return "redirect:/Client";
	}
	

//	@RequestMapping(value="/countries/update",method= {RequestMethod.PUT,RequestMethod.GET})
//	public String update(Integer id, String capital, String description) {
//		countryservice.update(id,  capital, description);
//		return "redirect:/country";
//	}
//	
	
	
	@RequestMapping (value="/Client/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		clientservice.delete(id);
		return "redirect:/Client";
	}
	

	
}
