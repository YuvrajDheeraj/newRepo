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
import ls.models.Invoice;
import ls.models.InvoiceStatus;
import ls.services.ClientService;
import ls.services.InvoiceService;
import ls.services.InvoiceStatusService;

@Controller

public class InvoiceController {
	@Autowired 
	private InvoiceService invoiceservice;
	@Autowired
	private ClientService  clientservice;
	@Autowired
	private InvoiceStatusService invoicestatusservice;
	
//	@RequestMapping ("state")
//	public String state() {
//		return "state";
//	}
	
	@RequestMapping("Invoice")
	public String getInvoice(Model model) {
		List<Invoice> invoicelist=invoiceservice.getinvoice();
		List<Client> ClientList=clientservice.getClient();
		List<InvoiceStatus> invoiceStatusList=invoicestatusservice.getInvoiceStatus();
		model.addAttribute("invoice", invoicelist);
		model.addAttribute("client",ClientList);
		model.addAttribute("invoicestatus", invoiceStatusList);
		return "invoice";
	}
	
	@PostMapping ("Invoice/addNew")
	public String saveInvoice(Invoice invoice) {
		invoiceservice.save(invoice);
		return "redirect:/Invoice";
		
	}
	
	@PostMapping ("Invoice/update")
	public String updateInvoice(Invoice invoice) {
		invoiceservice.save(invoice);
		return "redirect:/Invoice";
	}
	
	@RequestMapping("Invoice/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id){
		return invoiceservice.findById(id);
	}
	
	@RequestMapping(value="Invoice/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		invoiceservice.delete(id);
		return "redirect:/Invoice";
	}
	
	
	
	
}
