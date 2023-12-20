package mae.cna.di.monde_rural.exception;

public class RaceFamilleAlreadyExistException extends RuntimeException {

	public RaceFamilleAlreadyExistException ()
	{
		super("La Race ou Famille existe deja");
	}
	
}
