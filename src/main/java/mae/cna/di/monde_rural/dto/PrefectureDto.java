package mae.cna.di.monde_rural.dto;


public class PrefectureDto {
	
	private String uuid;
	
	private String code;
	
	private String libelle;
	
	private String description;

	private String regionAdministrativeUuid;
	
	private String regionAdministrativeLibelle;

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

	public String getRegionAdministrativeUuid() {
		return regionAdministrativeUuid;
	}

	public void setRegionAdministrativeUuid(String regionAdministrativeUuid) {
		this.regionAdministrativeUuid = regionAdministrativeUuid;
	}

	public String getRegionAdministrativeLibelle() {
		return regionAdministrativeLibelle;
	}

	public void setRegionAdministrativeLibelle(String regionAdministrativeLibelle) {
		this.regionAdministrativeLibelle = regionAdministrativeLibelle;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
	
}
