package mae.cna.di.monde_rural.exception;


public class UtilisateurNotFoundException extends RuntimeException {

	
	public UtilisateurNotFoundException (String uuidChambre)
	{
		super("L'utilisateur est introuvable");
	}
	
}
