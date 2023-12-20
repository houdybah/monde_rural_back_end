package mae.cna.di.monde_rural.exception;

public class PrefectureAlreadyExistException extends RuntimeException {

	public PrefectureAlreadyExistException ()
	{
		super("La Prefecture existe deja");
	}
	
}
