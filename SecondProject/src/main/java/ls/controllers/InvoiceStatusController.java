package ls.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ls.models.InvoiceStatus;
import ls.services.CountryService;
import ls.services.InvoiceStatusService;
import ls.services.StateService;

@Controller
public class InvoiceStatusController {
	
	@Autowired private InvoiceStatusService invoicestatusservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;
	

	
	@RequestMapping("invoiceStatus")
	public String getInvoiceStatus(Model model){
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		model.addAttribute("invoicestatus", invoicestatusservice.getInvoiceStatus());
		return "invoiceStatus";
	}
	
	@RequestMapping("invoiceStatus/addNew")
	public String save(InvoiceStatus invoicestatus) {
		invoicestatusservice.save(invoicestatus);
		return "redirect:/invoiceStatus";
	}

	@PostMapping("invoiceStatus/update")
	public String update(InvoiceStatus invoicestatus) {
		invoicestatusservice.save(invoicestatus);
		return "redirect:/invoiceStatus";
	}
	
	@RequestMapping("invoiceStatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id){
		return invoicestatusservice.findById(id);
	}
	
	@RequestMapping(value="invoiceStatus/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		invoicestatusservice.delete(id);
		return "redirect:/invoiceStatus";
	}
}
