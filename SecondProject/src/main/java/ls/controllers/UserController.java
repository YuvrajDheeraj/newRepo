package ls.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.State;
import ls.models.User;
import ls.services.CountryService;
import ls.services.StateService;
import ls.services.UserService;

@Controller 
public class UserController {
	@Autowired UserService userservice;
	@Autowired StateService stateservice;
	@Autowired CountryService countryservice;
	
//	@RequestMapping("user")
//	public String user() {
//		return "user";
//	}
	
	//@PostMapping("user")
//	@RequestMapping("user")
	
//	@GetMapping("User")
//	public String getUser(Model model) {
//		model.addAttribute("state",stateservice.getStates());
//		model.addAttribute("country",countryservice.getCountries());
//		return "user";
//	}
	
	@RequestMapping("user")
	public String getUsers(Model model) {
		List<State> statelist=stateservice.getStates();
		model.addAttribute("state", statelist);
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("user",userservice.getUser());
		return "user";
	}
	
	@PostMapping("User/addNew")
	public String addNew(User user) {
		userservice.save(user);
		return "redirect:/user";
	}
	
	
	
	@RequestMapping("User/findById")
	@ResponseBody
	public Optional<User> findById(int id) {
		return userservice.findById(id);
	}
	
	@RequestMapping(value="/User/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(User user) {
		userservice.save(user);
		return "redirect:/user";
	}

	
	@RequestMapping (value="/User/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		userservice.delete(id);
		return "redirect:/user";
	}


}
