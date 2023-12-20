package mae.cna.di.monde_rural.dto;

import java.util.Date;

public class CooperativeDto {
	
	private String uuid;
	
	private String code;
	
	private String libelle;
	
	private String description;
	
	private String adresse;
	
	private String contact;
	
	private String email;
	
	private String plateForme;
	
	private Date dateCreation;
	
	private String referenceAgrement;

	private String copieAgrementUuid;
	
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

	public String getCopieAgrementUuid() {
		return copieAgrementUuid;
	}

	public void setCopieAgrementUuid(String copieAgrementUuid) {
		this.copieAgrementUuid = copieAgrementUuid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	

	
}
