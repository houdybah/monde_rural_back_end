package mae.cna.di.monde_rural.exception;

public class CooperativeAlreadyExistException extends RuntimeException {

	public CooperativeAlreadyExistException ()
	{
		super("La Cooperative existe deja");
	}
	
}
