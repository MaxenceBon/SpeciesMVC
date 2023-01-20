package fr.diginamic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.enums.Sex;
import fr.diginamic.model.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {
	
	List<Animal> findByName(String name);
	
	List<Animal> findAnimalByColorIn(List<String> color);
	
	@Query("SELECT COUNT(a) FROM Animal a WHERE a.sex= :sex")
	Integer findBySex(@Param("sex")Sex sex);
	
}
