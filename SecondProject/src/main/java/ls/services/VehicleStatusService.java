package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.VehicleStatus;
import ls.repositories.VehicleStatusRepository;

@Service 
public class VehicleStatusService {
	
@Autowired VehicleStatusRepository vehiclestatusrepository;
	
	public List<VehicleStatus> getVehicleStatus(){
		return vehiclestatusrepository.findAll();
	}
	
	public void save(VehicleStatus vehiclestatus) {
		vehiclestatusrepository.save(vehiclestatus);
	}

	public Optional<VehicleStatus> findById(int id){
		return vehiclestatusrepository.findById(id);
		
	}
	
	public void delete(int id) {
		vehiclestatusrepository .deleteById(id);
	}
	

}
