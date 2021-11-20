package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.User;
import ls.repositories.UserRepository;

@Service 
public class UserService {
	@Autowired private UserRepository userrepository;
	
	public List<User> getUser(){
		return userrepository.findAll();
	}
	
	public void save(User user) {
		userrepository.save(user);
	}

	public Optional<User> findById(int id){
		return findById(id);
		
	}
	
	public void delete(int id) {
		userrepository.deleteById(id);
	}
}
