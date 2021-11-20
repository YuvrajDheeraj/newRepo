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

import ls.models.Contact;
import ls.services.CountryService;
import ls.services.StateService;
import ls.services.ContactService;

@Controller

public class ContactController {


	@Autowired
	private ContactService contactservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;

	@RequestMapping ("contact")
	public String getContact(Model model) {
		List<Contact> ContactList=contactservice.getContact();
		model.addAttribute("contact", ContactList);
		return "contact";
	}
	
	@PostMapping("Contact/addNew")
	public String addNew(Contact contact) {
		contactservice.save(contact);
		return "redirect:/contact";
	}
	
	
	
	@RequestMapping("Contact/findById")
	@ResponseBody
	public Optional<Contact> findById(int id) {
		return contactservice.findById(id);
	}
	
	@RequestMapping(value="/Contact/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Contact contact) {
		contactservice.save(contact);
		return "redirect:/contact";
	}

	
	@RequestMapping (value="/Contact/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		contactservice.delete(id);
		return "redirect:/contact";
	}


}
