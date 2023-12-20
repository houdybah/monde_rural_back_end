package mae.cna.di.monde_rural.exception;


public class DomaineNotFoundException extends RuntimeException {

	
	public DomaineNotFoundException (String uuidChambre)
	{
		super("Le Domaine est introuvable");
	}
	
}
