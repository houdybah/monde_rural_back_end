package mae.cna.di.monde_rural.exception;

public class DistrictQuartierAlreadyExistException extends RuntimeException {

	public DistrictQuartierAlreadyExistException ()
	{
		super("Le District ou quartier existe deja");
	}
	
}
