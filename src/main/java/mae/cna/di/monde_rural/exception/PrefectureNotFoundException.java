package mae.cna.di.monde_rural.exception;


public class PrefectureNotFoundException extends RuntimeException {

	
	public PrefectureNotFoundException (String uuidChambre)
	{
		super("La Prefecture est introuvable");
	}
	
}
