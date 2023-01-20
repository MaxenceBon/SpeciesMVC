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

import fr.diginamic.model.Animal;
import fr.diginamic.repository.AnimalRepository;
import fr.diginamic.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Controller
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	
	/** GetMapping de la liste des animaux
	 * Lien vers list_animal.html
	 */
	@GetMapping("/animal")
	public String animalList(Model model) {
		List<Animal> animalList = (List<Animal>) animalRepository.findAll();
		model.addAttribute("animalList", animalList);
		return "list_animal";
	}
	
	
	/** GetMapping de l'update d'un animal
	 * Lien vers update_animal.html
	 * addAttribute de species pour récupérer la liste des espèces
	 */
	@GetMapping("/animal/{id}")
	public String initUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Animal> animal = animalRepository.findById(id);
		if (animal.isPresent()) {
			model.addAttribute(animal.get());
			model.addAttribute("species", speciesRepository.findAll());
			return "update_animal";
		}
	return "error";
	}
	
	
	/** GetMapping de la création d'un animal
	 * Lien vers create_animal.html
	 * addAttribute de species pour récupérer la liste des espèces
	 */
	@GetMapping("/animal/create")
	public String initCreate(Model model) {
	model.addAttribute(new Animal());
	model.addAttribute("species", speciesRepository.findAll());
	return "create_animal";
	}
	
	
	/** PostMapping de la création et update d'un animal
	 * retourne vers GetMapping de animal
	 */
	@PostMapping("/animal")
	public String updateAnimal(@Valid Animal animal, BindingResult result) {
		if(result.hasErrors()) {
			return "create_animal";
		}
		this.animalRepository.save(animal);
		return "redirect:/animal";
	}

	
	/** GetMapping de la délétion d'un animal
	 */
	@GetMapping("animal/delete/{id}")
	public String deleteAnimal(@PathVariable("id") Integer animalId) {
		animalRepository.deleteById(animalId);
		return "redirect:/animal";
	}
	
}
