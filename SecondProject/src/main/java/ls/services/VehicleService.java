package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.Vehicle;
import ls.repositories.VehicleRepository;

@Service 
public class VehicleService {
	@Autowired
	private VehicleRepository vehiclerepository;

	public List<Vehicle> getVehicle(){
		return vehiclerepository.findAll();
	}
	
	
	public void save(Vehicle vehicle) {
		vehiclerepository.save(vehicle);
	}
	
	public Optional<Vehicle>  findById(int id) {
		return vehiclerepository.findById(id);
		
	}

	public void delete(int id) {
		vehiclerepository.deleteById(id);
	}

}
