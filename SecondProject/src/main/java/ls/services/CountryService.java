package ls.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ls.models.Country;
import ls.repositories.CountryRepository;

@Service 
public class CountryService {

	@Autowired
	private CountryRepository  countryrepository;
	
//	Display country
	
	public List<Country> getCountries(){
		return countryrepository.findAll();
	}
	
//	save new country
	public void save(Country country) {
		countryrepository.save(country);
	}
	
	//find by id
	
	public Optional<Country> findById(int id) {
		return countryrepository .findById(id);
	}
	
	//delete by id
	
	public void delete(int id) {
		countryrepository.deleteById(id);
	}
	
	//update by Query
//	public void update(Integer id, String capital, String description) {
//	countryrepository.update(id,  capital, description );
//}
}
