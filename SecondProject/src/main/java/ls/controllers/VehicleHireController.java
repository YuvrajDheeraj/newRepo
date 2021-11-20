package ls.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class VehicleHireController {
	@RequestMapping("vehicleHire")
	public String vehicleHire() {
		return "vehicleHire";
	}

}
