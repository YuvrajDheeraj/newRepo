package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.Client;
import ls.repositories.ClientRepository;

@Service 
public class ClientService {
@Autowired private ClientRepository clientrepository;
	
	public List<Client> getClient(){
		return clientrepository.findAll();
	}
	
	
	public void save(Client client) {
		clientrepository.save(client);
	}
	
	public Optional<Client>  findById(int id) {
		return clientrepository.findById(id);
		
	}

	public void delete(int id) {
		clientrepository.deleteById(id);
	}

}
