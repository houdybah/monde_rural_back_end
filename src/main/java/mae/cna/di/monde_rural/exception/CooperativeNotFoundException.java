package mae.cna.di.monde_rural.exception;


public class CooperativeNotFoundException extends RuntimeException {

	
	public CooperativeNotFoundException (String uuidChambre)
	{
		super("La Cooperative est introuvable");
	}
	
}
