package mae.cna.di.monde_rural.dto;

import java.util.Date;


public class DomainesCooperativeDto {
	
	private String uuid;
	
	private String cooperativeUuid;
	
	private String cooperativeLibelle;
	
	private String domaineUuid;
	
	private String domaineLibelle;
	
	private String activites;
	
	private Date dateDebut;
	
	private Date dateFin;

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

	public String getDomaineUuid() {
		return domaineUuid;
	}

	public void setDomaineUuid(String domaineUuid) {
		this.domaineUuid = domaineUuid;
	}

	public String getDomaineLibelle() {
		return domaineLibelle;
	}

	public void setDomaineLibelle(String domaineLibelle) {
		this.domaineLibelle = domaineLibelle;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
}
