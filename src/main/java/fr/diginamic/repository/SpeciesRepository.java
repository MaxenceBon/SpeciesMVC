package fr.diginamic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.model.Species;

@Repository
public interface SpeciesRepository extends CrudRepository<Species, Integer> {
	
	List<Species> findByCommonName(String commonName);
	
	List<Species> findFirstSpeciesByCommonName(String commonName);
	
	List<Species> findByLatinNameIgnoreCase(String latinName);
	
	@Query("SELECT s FROM Species s ORDER BY s.commonName Asc")
	List<Species> findBySpeciesOrderByCommonNameAsc();
	
//	@Query("SELECT s FROM Species s WHERE s.commonName LIKE s.commonName= :commonName")
	@Query("from Species where commonName= :commonName")
	List<Species> findBySpeciesByCommonNameEqual(@Param("commonName")String commonName);
	
}
