package mae.cna.di.monde_rural.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Lieu extends AbstractDomainClass {
	
	private String longitude;
	
	private String latitude;
	
	private String description;
	
	@ManyToOne
	private VillageSecteur villageSecteur;

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VillageSecteur getVillageSecteur() {
		return villageSecteur;
	}

	public void setVillageSecteur(VillageSecteur villageSecteur) {
		this.villageSecteur = villageSecteur;
	}

	
	
}
