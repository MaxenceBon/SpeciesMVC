package fr.diginamic.model;

import fr.diginamic.enums.Sex;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
public class Animal {

	
	/** id de l'animal
	 * Integer
	 * autogénérée
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	/** couleur de l'animal
	 * String
	 */
	@Column(name="color")
	private String color;
		
	
	/** nom de l'animal
	 * String
	 */
	@Column(name="name")
	@NotEmpty
	@Size(min=0,max=50)
	private String name;
	
	
	/** sexe de l'animal
	 * Enum
	 */
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	
	/** espèce de l'animal
	 * Species
	 */
	@ManyToOne
	@NotEmpty
	private Species species;
	
	
	@Override
    public String toString() {
        return name;
    }

	/** Getter pour id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter pour id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter pour color
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/** Setter pour color
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/** Getter pour name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Setter pour name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter pour sexe
	 * @return the sexe
	 */
	public Sex getSex() {
		return sex;
	}

	/** Setter pour sexe
	 * @param sexe the sexe to set
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/** Getter pour specie
	 * @return the specie
	 */
	public Species getSpecies() {
		return species;
	}

	/** Setter pour specie
	 * @param specie the specie to set
	 */
	public void setSpecies(Species species) {
		this.species = species;
	}

	
	
}	