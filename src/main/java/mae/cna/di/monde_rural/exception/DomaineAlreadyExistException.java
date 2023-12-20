package mae.cna.di.monde_rural.exception;

public class DomaineAlreadyExistException extends RuntimeException {

	public DomaineAlreadyExistException ()
	{
		super("Le Domaine existe deja");
	}
	
}
