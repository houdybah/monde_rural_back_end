package mae.cna.di.monde_rural.dto;

import java.util.Date;

import mae.cna.di.monde_rural.domain.enumeration.EnumGenre;
import mae.cna.di.monde_rural.domain.enumeration.EnumResponsabiliteMembre;


public class MembreEtProducteurDto {

	private String uuid;
    
	private String matricule;

    private String nom;

    private String prenom;
    
    private String adresse;
    
    private String contact;
    
    private String email;
    
    private String lieuNaissance;
    
    private Date dateNaissance;

    private EnumGenre genre;
    
    private String prenomPere;
    
    private String nomMere;
    
    private String prenomMere;
    
    private String cooperativeUuid;
    
    private String cooperativeLibelle;
    
    private EnumResponsabiliteMembre responsabilite;
 
    private String userUuid;
    
    private String userLibelle;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	

	public EnumGenre getGenre() {
		return genre;
	}

	public void setGenre(EnumGenre genre) {
		this.genre = genre;
	}

	public String getPrenomPere() {
		return prenomPere;
	}

	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}

	public String getNomMere() {
		return nomMere;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public String getPrenomMere() {
		return prenomMere;
	}

	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}

	public String getCooperativeUuid() {
		return cooperativeUuid;
	}

	public void setCooperativeUuid(String cooperativeUuid) {
		this.cooperativeUuid = cooperativeUuid;
	}

	public String getCooperativeLibelle() {
		return cooperativeLibelle;
	}

	public void setCooperativeLibelle(String cooperativeLibelle) {
		this.cooperativeLibelle = cooperativeLibelle;
	}

	public EnumResponsabiliteMembre getResponsabilite() {
		return responsabilite;
	}

	public void setResponsabilite(EnumResponsabiliteMembre responsabilite) {
		this.responsabilite = responsabilite;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getUserLibelle() {
		return userLibelle;
	}

	public void setUserLibelle(String userLibelle) {
		this.userLibelle = userLibelle;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

    
    
       
}
