package mae.cna.di.monde_rural.exception;

public class PersonnelAlreadyExistException extends RuntimeException {

	public PersonnelAlreadyExistException ()
	{
		super("Le membre du personnel existe deja");
	}
	
}
