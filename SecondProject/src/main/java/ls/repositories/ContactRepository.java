package ls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ls.models.Client;
import ls.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}