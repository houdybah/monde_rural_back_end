package mae.cna.di.monde_rural.exception;

public class EspeceAlreadyExistException extends RuntimeException {

	public EspeceAlreadyExistException ()
	{
		super("L'espece existe deja");
	}
	
}
