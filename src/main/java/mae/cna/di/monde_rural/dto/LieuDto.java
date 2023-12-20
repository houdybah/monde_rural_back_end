package mae.cna.di.monde_rural.dto;


public class LieuDto {
	
	private String uuid;	
	
	private String longitude;
	
	private String latitude;
	
	private String description;
	
	private String villageSecteurUuid;
	
	private String villageSecteurLibelle;

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

	public String getVillageSecteurUuid() {
		return villageSecteurUuid;
	}

	public void setVillageSecteurUuid(String villageSecteurUuid) {
		this.villageSecteurUuid = villageSecteurUuid;
	}

	public String getVillageSecteurLibelle() {
		return villageSecteurLibelle;
	}

	public void setVillageSecteurLibelle(String villageSecteurLibelle) {
		this.villageSecteurLibelle = villageSecteurLibelle;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
}
