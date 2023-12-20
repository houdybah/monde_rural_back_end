package mae.cna.di.monde_rural.exception;

public class VillageSecteurAlreadyExistException extends RuntimeException {

	public VillageSecteurAlreadyExistException ()
	{
		super("Le Village ou Secteur existe deja");
	}
	
}
