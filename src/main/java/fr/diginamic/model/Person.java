package fr.diginamic.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class Person {

	
	/** id de la personne
	 * Integer
	 * autogénérée
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	/** age de la personne
	 * int
	 */
	@Column(name="age")
	private int age;
		
	
	/** prénom de la personne
	 * String
	 */
	@Column(name="firstname")
	@NotEmpty
	@Size(min=0,max=50)
	private String firstName;
	
	
	/** nom de la personne
	 * String
	 */
	@Column(name="lastname")
	@NotEmpty
	@Size(min=0,max=50)
	private String lastName;
	
	
	/** Liste des animaux
	 * Set
	 */
	@ManyToMany(fetch = FetchType.EAGER)
    Set<Animal> animals;

	
	/** Méthode qui permet d'ajouter un animal à animals
	 */
	public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

	/** Méthode qui permet d'enlever un animal à animals
	 */
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", age=" + age +
                ", animals=" + animals +
                '}';
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

	/** Getter pour age
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/** Setter pour age
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** Getter pour firstName
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/** Setter pour firstName
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Getter pour lastName
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** Setter pour lastName
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Getter pour animals
	 * @return the animals
	 */
	public Set<Animal> getAnimals() {
		return animals;
	}

	/** Setter pour animals
	 * @param animals the animals to set
	 */
	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}
    
    
	
}
