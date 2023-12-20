package mae.cna.di.monde_rural.exception;

public class SousPrefectureAlreadyExistException extends RuntimeException {

	public SousPrefectureAlreadyExistException ()
	{
		super("La Sous Prefecture existe deja");
	}
	
}
