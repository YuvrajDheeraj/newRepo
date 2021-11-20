package ls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ls.models.State;
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
