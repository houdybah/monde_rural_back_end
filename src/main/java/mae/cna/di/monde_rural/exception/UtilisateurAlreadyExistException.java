package mae.cna.di.monde_rural.exception;

public class UtilisateurAlreadyExistException extends RuntimeException {

	public UtilisateurAlreadyExistException ()
	{
		super("L'email existe deja");
	}
	
}
