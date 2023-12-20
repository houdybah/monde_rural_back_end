package mae.cna.di.monde_rural.dto;


public class DomaineDto{
	
	private String uuid;
	
	private String libelle;
	
	private String description;
	
	private String typeDomaineUuid;
	
	private String typeDomaineLibelle;

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

	public String getTypeDomaineUuid() {
		return typeDomaineUuid;
	}

	public void setTypeDomaineUuid(String typeDomaineUuid) {
		this.typeDomaineUuid = typeDomaineUuid;
	}

	public String getTypeDomaineLibelle() {
		return typeDomaineLibelle;
	}

	public void setTypeDomaineLibelle(String typeDomaineLibelle) {
		this.typeDomaineLibelle = typeDomaineLibelle;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
}