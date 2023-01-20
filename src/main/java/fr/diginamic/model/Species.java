package fr.diginamic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Species {

	
	/** id de l'espèce
	 * Integer
	 * autogénérée
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	/** nom commun de l'espèce
	 * String
	 */
	@Column(name="common_name")
	@NotEmpty
	@Size(min=0,max=50)
	private String commonName;
	
	
	/** nom latin de l'espèce
	 * String
	 */
	@Column(name="latin_name")
	@NotEmpty
	@Size(min=0,max=120)
	private String latinName;
	
	
	@Override
    public String toString() {
        return commonName;
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

	/** Getter pour common_name
	 * @return the common_name
	 */
	public String getCommonName() {
		return commonName;
	}

	/** Setter pour common_name
	 * @param common_name the common_name to set
	 */
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	/** Getter pour latinName
	 * @return the latinName
	 */
	public String getLatinName() {
		return latinName;
	}

	/** Setter pour latinName
	 * @param latinName the latinName to set
	 */
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}

}