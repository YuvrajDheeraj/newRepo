package ls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ls.models.VehicleMovement;
@Repository

public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
