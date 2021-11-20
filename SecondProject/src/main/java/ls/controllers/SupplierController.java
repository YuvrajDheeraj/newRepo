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

import ls.models.Supplier;
import ls.services.SupplierService;
import ls.services.CountryService;
import ls.services.StateService;

@Controller 
public class SupplierController {
	
	@Autowired
	private SupplierService supplierservice;
	@Autowired private StateService stateservice;
	@Autowired private CountryService countryservice;

	@RequestMapping ("supplier")
	public String getCountries(Model model) {
		model.addAttribute("country",countryservice.getCountries());
		model.addAttribute("state", stateservice.getStates());
		List<Supplier> SupplierList=supplierservice.getSupplier();
		model.addAttribute("supplier", SupplierList);
		return "supplier";
	}
	
	@PostMapping("Supplier/addNew")
	public String addNew(Supplier supplier) {
		supplierservice.save(supplier);
		return "redirect:/supplier";
	}
	
	
	
	@RequestMapping("Supplier/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id) {
		return supplierservice.findById(id);
	}
	
	@RequestMapping(value="/Supplier/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierservice.save(supplier);
		return "redirect:/supplier";
	}

	
	@RequestMapping (value="/Supplier/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		supplierservice.delete(id);
		return "redirect:/supplier";
	}

}
