package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.VehicleModel;
import ls.repositories.VehicleModelRepository;

@Service 
public class VehicleModelService {

	
@Autowired VehicleModelRepository vehiclemodelrepository;
	
	public List<VehicleModel> getVehicleModel(){
		return vehiclemodelrepository.findAll();
	}
	
	public void save(VehicleModel vehiclemodel) {
		vehiclemodelrepository.save(vehiclemodel);
	}

	public Optional<VehicleModel> findById(int id){
		return vehiclemodelrepository.findById(id);
		
	}
	
	public void delete(int id) {
		vehiclemodelrepository .deleteById(id);
	}
	
}
