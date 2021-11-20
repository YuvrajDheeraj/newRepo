package ls.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ls.models.VehicleMake;
import ls.repositories.VehicleMakeRepository;

@Service 
public class VehicleMakeService {
	
@Autowired VehicleMakeRepository vehiclemakerepository;
	
	public List<VehicleMake> getVehicleMake(){
		return vehiclemakerepository.findAll();
	}
	
	public void save(VehicleMake vehiclemake) {
		vehiclemakerepository.save(vehiclemake);
	}

	public Optional<VehicleMake> findById(int id){
		return vehiclemakerepository.findById(id);
		
	}
	
	public void delete(int id) {
		vehiclemakerepository .deleteById(id);
	}
	

	

}
