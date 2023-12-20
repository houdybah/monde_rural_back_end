package mae.cna.di.monde_rural.dto;


public class EspeceDto {
	
	private String uuid;
	
	private String code;
	
	private String libelle;
	
	private String description;
	
	private String domaineUuid;
	
	private String domaineLibelle;

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
	
}