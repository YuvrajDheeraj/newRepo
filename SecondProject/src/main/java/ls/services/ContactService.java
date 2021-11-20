package ls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.models.Contact;
import ls.repositories.ContactRepository;

@Service 
public class ContactService {

@Autowired private ContactRepository contactrepository;
	
	public List<Contact> getContact(){
		return contactrepository.findAll();
	}
	
	
	public void save(Contact contact) {
		contactrepository.save(contact);
	}
	
	public Optional<Contact>  findById(int id) {
		return contactrepository.findById(id);
		
	}

	public void delete(int id) {
		contactrepository.deleteById(id);
	}


	
}
