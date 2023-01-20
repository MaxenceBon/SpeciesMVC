package fr.diginamic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.diginamic.model.Person;
import fr.diginamic.repository.AnimalRepository;
import fr.diginamic.repository.PersonRepository;
import jakarta.validation.Valid;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	
	/** GetMapping de la liste des personnes
	 * Lien vers list_person.html
	 */
	@GetMapping("/person")
	public String personList(Model model) {
		List<Person> personList = (List<Person>) personRepository.findAll();
		model.addAttribute("personList", personList);
		return "list_person";
	}
	
	
	/** GetMapping de l'update d'une personne
	 * Lien vers update_person.html
	 * addAttribute de animals pour récupérer la liste des animaux
	 */
	@GetMapping("/person/{id}")
	public String initUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			model.addAttribute("person",person.get());
			model.addAttribute("animals",animalRepository.findAll());
			return "update_person";
		}
	return "error";
	}
	
	
	/** GetMapping de la création d'une personne
	 * Lien vers create_person.html
	 * addAttribute de animals pour récupérer la liste des animaux
	 */
	@GetMapping("/person/create")
	public String initCreate(Model model) {
	model.addAttribute("person",new Person());
	model.addAttribute("animals", animalRepository.findAll());
	return "create_person";
	}
	
	
	/** PostMapping de la création et update d'une personne
	 * retourne vers GetMapping de person
	 */
	@PostMapping("/person")
	public String updatePerson(@Valid Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "create_person";
		}
		this.personRepository.save(person);
		return "redirect:/person";
	}

	
	/** GetMapping de la délétion d'une personne
	 */
	@GetMapping("person/delete/{id}")
	public String deletePerson(@PathVariable("id") Integer personId) {
		personRepository.deleteById(personId);
		return "redirect:/person";
	}
	
}