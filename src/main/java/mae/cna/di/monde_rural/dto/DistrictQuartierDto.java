package mae.cna.di.monde_rural.dto;


import javax.persistence.ManyToOne;

public class DistrictQuartierDto{
	
	private String uuid;
	
	private String code;
	
	private String libelle;
	
	private String description;
	
	@ManyToOne
	private SousPrefectureDto sousPrefectureDto;

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

	public SousPrefectureDto getSousPrefecture() {
		return sousPrefectureDto;
	}

	public void setSousPrefecture(SousPrefectureDto sousPrefectureDto) {
		this.sousPrefectureDto = sousPrefectureDto;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public SousPrefectureDto getSousPrefectureDto() {
		return sousPrefectureDto;
	}

	public void setSousPrefectureDto(SousPrefectureDto sousPrefectureDto) {
		this.sousPrefectureDto = sousPrefectureDto;
	}

	

	
}
