package mae.cna.di.monde_rural.exception;


public class EmailInvalidException extends RuntimeException {

	
	public EmailInvalidException ()
	{
		super("L'email est invalide");
	}
	
}
