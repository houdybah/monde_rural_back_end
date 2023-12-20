package mae.cna.di.monde_rural.exception;

public class RegionNaturelleAlreadyExistException extends RuntimeException {

	public RegionNaturelleAlreadyExistException ()
	{
		super("La Region Naturelle existe deja");
	}
	
}
