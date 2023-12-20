package mae.cna.di.monde_rural.exception;


public class DomaineCooperativeNotFoundException extends RuntimeException {

	
	public DomaineCooperativeNotFoundException (String uuidChambre)
	{
		super("Le domaine de cooperative est introuvable");
	}
	
}
