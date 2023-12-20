package mae.cna.di.monde_rural.exception;

public class RegionAdministrativeAlreadyExistException extends RuntimeException {

	public RegionAdministrativeAlreadyExistException ()
	{
		super("La Region Administrative existe deja");
	}
	
}
