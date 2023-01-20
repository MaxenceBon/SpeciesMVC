package fr.diginamic.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.diginamic.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
    public int deletePersonsWithoutAnimal() {
        jakarta.persistence.Query sqlQuery = em.createNativeQuery("delete p from person p left join person_animals pa on p.id = pa.person_id where pa.animals_id is null");
        return sqlQuery.executeUpdate();
    }

    @Override
    public void insertRandomPersons(int numberToCreate) {
        Random rand = new Random();
        List<String> noms = Arrays.asList("Blanc", "Boudi", "Brahmi", "Brun", "Duflot", "Grobost", "Guigue", "Haned", "Mohamed", "Vignozzi", "Omari", "Ramier", "Randrianarivony", "Warin", "Mage");
        List<String> prenoms = Arrays.asList("David", "Mohand", "Sonia", "Justine", "Valentin", "Garmi", "Véronique", "Abderrahmane", "Amin", "Aurélie", "Ismail", "Alexandre", "Rijandrisolo", "Thomas", "Jordi");

        for (int i = 0; i < numberToCreate ; i++) {
            Person p = new Person();
            p.setAge(rand.nextInt(120));
            p.setFirstName(prenoms.get(rand.nextInt(prenoms.size())));
            p.setLastName(noms.get(rand.nextInt(noms.size())));
            em.persist(p);
        }
    }

	
}
