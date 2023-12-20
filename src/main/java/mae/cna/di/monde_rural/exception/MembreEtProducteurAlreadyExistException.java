package mae.cna.di.monde_rural.exception;

public class MembreEtProducteurAlreadyExistException extends RuntimeException {

	public MembreEtProducteurAlreadyExistException ()
	{
		super("Le Membre ou Producteur existe deja");
	}
	
}
