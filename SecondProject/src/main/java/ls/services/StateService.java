package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.State;
import ls.repositories.CountryRepository;
import ls.repositories.StateRepository;

@Service 
public class StateService {
	@Autowired private StateRepository staterepository;
	
	public List<State> getStates(){
		return staterepository.findAll();
	}
	
	
	public void save(State state) {
		staterepository.save(state);
	}
	
	public Optional<State>  findById(int id) {
		return staterepository.findById(id);
		
	}

	public void delete(int id) {
		staterepository .deleteById(id);
	}
}
