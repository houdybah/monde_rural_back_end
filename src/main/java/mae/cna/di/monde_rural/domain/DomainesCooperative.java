package mae.cna.di.monde_rural.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DomainesCooperative extends AbstractDomainClass {
	
	@ManyToOne
	private Cooperative cooperative;
	
	@ManyToOne
	private Domaine domaine;
	
	private String activites;
	
	private Date dateDebut;
	
	private Date dateFin;

	public Cooperative getCooperative() {
		return cooperative;
	}

	public void setCooperative(Cooperative cooperative) {
		this.cooperative = cooperative;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public String getActivites() {
		return activites;
	}

	public void setActivites(String activites) {
		this.activites = activites;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
}
