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

import fr.diginamic.model.Species;
import fr.diginamic.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Controller
public class SpeciesController {

	@Autowired
	private SpeciesRepository speciesRepository;
	
	
	/** GetMapping de la liste des espèces
	 * Lien vers list_species.html
	 */
	@GetMapping("/species")
	public String speciesList(Model model) {
		List<Species> speciesList = (List<Species>) speciesRepository.findAll();
		model.addAttribute("speciesList", speciesList);
		return "list_species";
	}
	
	
	/** GetMapping de l'update d'une espèce
	 * Lien vers update_species.html
	 */
	@GetMapping("/species/{id}")
	public String initUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Species> species = speciesRepository.findById(id);
		if (species.isPresent()) {
			model.addAttribute(species.get());
			return "update_species";
		}
	return "error";
	}
	
	
	/** GetMapping de la création d'une espèce
	 * Lien vers create_species.html
	 */
	@GetMapping("/species/create")
	public String initCreate(Model model) {
	model.addAttribute(new Species());
	return "create_species";
	}
	
	
	/** PostMapping de la création et update d'une espèce
	 * retourne vers GetMapping de species
	 */
	@PostMapping("/species")
	public String updateSpecies(@Valid Species species, BindingResult result) {
		if(result.hasErrors()) {
			return "create_species";
		}
		this.speciesRepository.save(species);
		return "redirect:/species";
	}

	
	/** GetMapping de la délétion d'une espèce
	 */
	@GetMapping("species/delete/{id}")
	public String deleteSpecies(@PathVariable("id") Integer speciesId) {
		speciesRepository.deleteById(speciesId);
		return "redirect:/species";
	}
	
}
