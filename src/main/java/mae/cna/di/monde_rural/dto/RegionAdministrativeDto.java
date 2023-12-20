package mae.cna.di.monde_rural.dto;


public class RegionAdministrativeDto {
	
	private String uuid;
	
	private String code;
	
	private String libelle;
	
	private String description;

	private String regionNaturelleUuid;
	
	private String regionNaturelleLibelle;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getRegionNaturelleUuid() {
		return regionNaturelleUuid;
	}

	public void setRegionNaturelleUuid(String regionNaturelleUuid) {
		this.regionNaturelleUuid = regionNaturelleUuid;
	}

	public String getRegionNaturelleLibelle() {
		return regionNaturelleLibelle;
	}

	public void setRegionNaturelleLibelle(String regionNaturelleLibelle) {
		this.regionNaturelleLibelle = regionNaturelleLibelle;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
}
