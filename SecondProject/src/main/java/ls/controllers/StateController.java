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


import ls.models.State;
import ls.services.StateService;

@Controller
public class StateController {
	@Autowired 
	private StateService stateservice;
	@Autowired CountryController  countryservice;
	
//	@RequestMapping ("state")
//	public String state() {
//		return "state";
//	}
	
	@RequestMapping("state")
	public String getStates(Model model) {
		List<State> statelist=stateservice.getStates();
		model.addAttribute("states", statelist);
		model.addAttribute("country",countryservice.getCountries(model));
		return "state";
	}
	
	@PostMapping ("states/addNew")
	public String saveState(State state) {
		stateservice.save(state);
		return "redirect:/state";
		
	}
	
	@PostMapping ("states/update")
	public String updateState(State state) {
		stateservice.save(state);
		return "redirect:/state";
	}
	
	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id){
		return stateservice.findById(id);
	}
	
	@RequestMapping(value="states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		stateservice.delete(id);
		return "redirect:/state";
	}
	
	
	
	
}
