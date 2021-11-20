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
import ls.models.VehicleMaintenance;
import ls.services.SupplierService;
import ls.services.VehicleMaintenanceService;
import ls.services.VehicleService;
@Controller 
public class VehicleMaintenanceController {
	
	@Autowired 
	private VehicleMaintenanceService vehiclemaintenanceservice;
	@Autowired
	private SupplierService supplierservice;
	@Autowired
	private VehicleService vehicleservice;
	
	
	@RequestMapping ("vehicleMaintenance")
	public String getvehicleMaintenance(Model model) {
		List<VehicleMaintenance> vmlist=vehiclemaintenanceservice.getVehicleMaintenance();
		model.addAttribute("vmlist", vmlist);
		model.addAttribute("supplier",supplierservice.getSupplier());
		model.addAttribute("vehicle", vehicleservice.getVehicle());
		return "vehicleMaintenance";
	}
	
	
	@PostMapping("VehicleMaintenance/addNew")
	public String addNew(VehicleMaintenance vehiclemaintenance) {
		vehiclemaintenanceservice.save(vehiclemaintenance);
		return "redirect:/vehicleMaintenance";
	}
	
	
	
	@RequestMapping("VehicleMaintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id) {
		return vehiclemaintenanceservice.findById(id);
	}
	
	@RequestMapping(value="/VehicleMaintenance/update",method= {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMaintenance vehiclemaintenance) {
		vehiclemaintenanceservice.save(vehiclemaintenance);
		return "redirect:/vehicleMaintenance";
	}

	
	@RequestMapping (value="/VehicleMaintenance/delete",method= {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(int id) {
		vehiclemaintenanceservice.delete(id);
		return "redirect:/vehicleMaintenance";
	}

	
	

}
