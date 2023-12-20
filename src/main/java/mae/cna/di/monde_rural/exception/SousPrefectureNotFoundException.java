package mae.cna.di.monde_rural.exception;


public class SousPrefectureNotFoundException extends RuntimeException {

	
	public SousPrefectureNotFoundException (String uuidChambre)
	{
		super("La Sous Prefecture est introuvable");
	}
	
}
