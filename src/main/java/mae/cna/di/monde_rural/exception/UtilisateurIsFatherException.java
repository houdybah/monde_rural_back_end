package mae.cna.di.monde_rural.exception;

public class UtilisateurIsFatherException extends RuntimeException {

	public UtilisateurIsFatherException (String uuidChambre)
	{
		super("L'utilisateur est liée avec d'autres enregistrements");
	}
}