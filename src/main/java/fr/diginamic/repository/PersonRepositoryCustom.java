package fr.diginamic.repository;

public interface PersonRepositoryCustom {

	int deletePersonsWithoutAnimal();

    void insertRandomPersons(int numberToCreate);
	
}
