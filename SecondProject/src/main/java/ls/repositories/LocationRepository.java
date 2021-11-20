package ls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ls.models.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
