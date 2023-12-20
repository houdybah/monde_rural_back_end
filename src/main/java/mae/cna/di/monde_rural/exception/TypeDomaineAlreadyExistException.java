package mae.cna.di.monde_rural.exception;

public class TypeDomaineAlreadyExistException extends RuntimeException {

	public TypeDomaineAlreadyExistException ()
	{
		super("Le Type de domaine existe deja");
	}
	
}
