package mae.cna.di.monde_rural.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import mae.cna.di.monde_rural.domain.enumeration.EnumGenre;


@Entity
public class Personnel extends AbstractDomainClass {

	@Column(nullable = false, unique = true)
    String matricule;

	@Column(nullable = false)
    String nom;

	@Column(nullable = false)
    String prenom;
    
    String adresse;
    
    @Column(nullable = false, unique = true)
    String contact;
    
    @Column(nullable = false, unique = true)
    String email;
    
    String lieuNaissance;
    
    Date dateNaissance;

    
    @Column(name = "GENRE", nullable = true)
    @Enumerated(EnumType.STRING)
    EnumGenre genre;
    
    @Column(name = "PRENOMPERE", nullable = true)
    String prenomPere;
    
    @Column(name = "NOMMERE", nullable = true)
    String nomMere;
    
    @Column(name = "PRENOMMERE", nullable = true)
    String prenomMere;
    
    @ManyToOne
    Chambre chambre;
    
    @OneToOne(mappedBy = "personnel")
    Utilisateur utilsateur;

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

	

	public Utilisateur getUtilsateur() {
		return utilsateur;
	}

	public void setUtilsateur(Utilisateur utilsateur) {
		this.utilsateur = utilsateur;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

       
}
