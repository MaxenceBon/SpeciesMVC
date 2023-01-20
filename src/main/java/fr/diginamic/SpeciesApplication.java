package fr.diginamic;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.enums.Sex;
import fr.diginamic.repository.AnimalRepository;
import fr.diginamic.repository.PersonRepository;
import fr.diginamic.repository.SpeciesRepository;

@SpringBootApplication
public class SpeciesApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(SpeciesApplication.class);

    @Autowired
    private AnimalRepository animalRepository;
    
    @Autowired
    private SpeciesRepository speciesRepository;
    
    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpeciesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//    	System.out.println("Entité animal :"+ this.animalRepository.findAll());
//    	logger.info("Toutes les espéces : {}", this.speciesRepository.findAll());
//    	System.out.println(this.speciesRepository.findFirstSpeciesByCommonName("Chat"));
//    	System.out.println(this.animalRepository.findByName("Max"));
//    	System.out.println(this.personRepository.findByFirstName("sylvie"));
//    	System.out.println(this.speciesRepository.findByLatinNameIgnoreCase("Felis silvestris catus"));
//    	System.out.println(this.personRepository.findByFirstNameOrLastName("Jean", "Nero"));
//    	System.out.println(this.personRepository.findByAgeGreaterThan(50));
//    	System.out.println(this.animalRepository.findAnimalByColorIn(List.of("Blanc","brun")));
//    	System.out.println(this.speciesRepository.findBySpeciesOrderByCommonNameAsc());
//    	System.out.println(this.animalRepository.findBySex(Sex.F));
//    	System.out.println(this.personRepository.findByAgeBetween());
//    	System.out.println(this.speciesRepository.findBySpeciesByCommonNameEqual("Chat"));
    	
    }
}
