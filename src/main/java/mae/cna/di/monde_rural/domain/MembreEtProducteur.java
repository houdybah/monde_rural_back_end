package mae.cna.di.monde_rural.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import mae.cna.di.monde_rural.domain.enumeration.EnumGenre;
import mae.cna.di.monde_rural.domain.enumeration.EnumResponsabiliteMembre;


@Entity
public class MembreEtProducteur extends AbstractDomainClass {

	@Column( unique = true)
    private String matricule;

	@Column(nullable = false)
    private String nom;

	@Column(nullable = false)
    private String prenom;
    
	@Column(nullable = false)
    private String adresse;
    
	@Column(nullable = false, unique = true)
    private String contact;
    
	@Column(nullable = false, unique = true)
    private String email;
    
    private String lieuNaissance;
    
    private Date dateNaissance;

    
    @Column(name = "GENRE", nullable = true)
    @Enumerated(EnumType.STRING)
    private EnumGenre genre;
    
    private String prenomPere;
    
    private String nomMere;
    
    private String prenomMere;
    
    @ManyToOne
    private Cooperative cooperative;
    
    private EnumResponsabiliteMembre responsabilite;
    
    @OneToOne(mappedBy = "membre")
    Utilisateur utilisateur;

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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Cooperative getCooperative() {
		return cooperative;
	}

	public void setCooperative(Cooperative cooperative) {
		this.cooperative = cooperative;
	}

	public EnumResponsabiliteMembre getResponsabilite() {
		return responsabilite;
	}

	public void setResponsabilite(EnumResponsabiliteMembre responsabilite) {
		this.responsabilite = responsabilite;
	}

	

       
}
