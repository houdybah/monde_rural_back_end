package mae.cna.di.monde_rural.exception;

public class DomaineIsFatherException extends RuntimeException {

	public DomaineIsFatherException (String uuidChambre)
	{
		super("Le Domaine est liée avec d'autres enregistrements");
	}
}