package mae.cna.di.monde_rural.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RegionNaturelle extends AbstractDomainClass {
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(nullable = false, unique = true)
	private String libelle;
	
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
}
