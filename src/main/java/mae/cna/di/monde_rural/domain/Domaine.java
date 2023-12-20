package mae.cna.di.monde_rural.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Domaine extends AbstractDomainClass {
	
	@Column(nullable = false, unique = true)
	private String libelle;
	
	private String description;
	
	@ManyToOne
	private TypeDomaine typeDomaine;

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

	public TypeDomaine getTypeDomaine() {
		return typeDomaine;
	}

	public void setTypeDomaine(TypeDomaine typeDomaine) {
		this.typeDomaine = typeDomaine;
	}
	
	
}