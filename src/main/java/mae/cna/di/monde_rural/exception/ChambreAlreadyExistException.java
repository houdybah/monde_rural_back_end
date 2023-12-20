package mae.cna.di.monde_rural.exception;

public class ChambreAlreadyExistException extends RuntimeException {

	public ChambreAlreadyExistException ()
	{
		super("La Chambre existe deja");
	}
	
}
