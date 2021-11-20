package ls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ls.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
//	@Modifying 
//	@Query(value = "update country c set c.description = ?1, c.capital = ?2 , c.code = ?3,"
//			+ " c.continent = ?4, c.nationality = ?5 where c.id = ?6",nativeQuery=true);
//	public void update(String description, String capital, String code,String continent,String nationality, Integer id);

//	@Modifying
//	@Query("update Customer c set c.description = :description, c.capital = :capital where c.id = :id")
//	public void update(@Param (value = "id") Integer id, @Param(value = "description") String description, @Param(value = "capital") String capital);

}

