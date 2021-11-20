package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.VehicleType;
import ls.repositories.VehicleTypeRepository;

@Service 
public class VehicleTypeService {
	
@Autowired VehicleTypeRepository vehicletyperepository;
	
	public List<VehicleType> getVehicleType(){
		return vehicletyperepository.findAll();
	}
	
	public void save(VehicleType vehicletype) {
		vehicletyperepository.save(vehicletype);
	}

	public Optional<VehicleType> findById(int id){
		return vehicletyperepository.findById(id);
		
	}
	
	public void delete(int id) {
		vehicletyperepository .deleteById(id);
	}
	

}
