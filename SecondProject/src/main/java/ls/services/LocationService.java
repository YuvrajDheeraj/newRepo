package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.Location;
import ls.repositories.LocationRepository;

@Service 
public class LocationService {
	@Autowired LocationRepository locationrepository;
	
	public List<Location> getLocation(){
		return locationrepository.findAll();
	}
	
	public void save(Location location) {
		locationrepository.save(location);
	}

	public Optional<Location> findById(int id){
		return locationrepository.findById(id);
		
	}
	
	public void delete(int id) {
		locationrepository .deleteById(id);
	}
	
}
