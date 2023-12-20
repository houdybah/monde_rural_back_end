package mae.cna.di.monde_rural.exception;

public class DomaineCooperativeAlreadyExistException extends RuntimeException {

	public DomaineCooperativeAlreadyExistException ()
	{
		super("Ce Domaine est deja lié a cette Cooperative");
	}
	
}
