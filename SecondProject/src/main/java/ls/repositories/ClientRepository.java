package ls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ls.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
