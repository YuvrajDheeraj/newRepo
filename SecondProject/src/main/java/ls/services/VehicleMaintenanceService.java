package ls.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ls.models.VehicleMaintenance;
import ls.repositories.VehicleMaintenanceRepository;
@Service 
public class VehicleMaintenanceService {
	
	@Autowired private VehicleMaintenanceRepository vehiclemaintenancerepository;
	
	public List<VehicleMaintenance> getVehicleMaintenance(){
		return vehiclemaintenancerepository.findAll();
	}
	
	public void save(VehicleMaintenance vehiclemaintenance) {
		vehiclemaintenancerepository.save(vehiclemaintenance);
	}
	
	public Optional<VehicleMaintenance>  findById(int id) {
		return vehiclemaintenancerepository.findById(id);
		
	}

	public void delete(int id) {
		vehiclemaintenancerepository.deleteById(id);
	}


}
