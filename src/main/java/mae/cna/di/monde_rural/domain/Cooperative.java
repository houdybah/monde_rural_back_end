package mae.cna.di.monde_rural.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cooperative extends AbstractDomainClass {
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(nullable = false, unique = true)
	private String libelle;
	
	private String description;
	
	@Column(nullable = false)
	private String adresse;
	
	@Column(nullable = false)
	private String contact;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column( unique = true)
	private String plateForme;
	
	private Date dateCreation;
	
	@Column(nullable = false, unique = true)
	private String referenceAgrement;
	
	@ManyToOne
	private StoredFile copieAgrement;
	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlateForme() {
		return plateForme;
	}

	public void setPlateForme(String plateForme) {
		this.plateForme = plateForme;
	}

	public String getReferenceAgrement() {
		return referenceAgrement;
	}

	public void setReferenceAgrement(String referenceAgrement) {
		this.referenceAgrement = referenceAgrement;
	}

	public StoredFile getCopieAgrement() {
		return copieAgrement;
	}

	public void setCopieAgrement(StoredFile copieAgrement) {
		this.copieAgrement = copieAgrement;
	}

	
}
