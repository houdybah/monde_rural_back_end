package mae.cna.di.monde_rural.exception;


public class EspeceNotFoundException extends RuntimeException {

	
	public EspeceNotFoundException (String uuidChambre)
	{
		super("L'espece est introuvable");
	}
	
}
