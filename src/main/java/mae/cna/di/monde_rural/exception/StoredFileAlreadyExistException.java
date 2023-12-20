package mae.cna.di.monde_rural.exception;

public class StoredFileAlreadyExistException extends RuntimeException {

	public StoredFileAlreadyExistException ()
	{
		super("Le Fichier existe deja");
	}
	
}
