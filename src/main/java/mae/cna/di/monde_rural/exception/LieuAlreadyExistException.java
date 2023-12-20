package mae.cna.di.monde_rural.exception;

public class LieuAlreadyExistException extends RuntimeException {

	public LieuAlreadyExistException ()
	{
		super("Le lieu existe deja");
	}
	
}
